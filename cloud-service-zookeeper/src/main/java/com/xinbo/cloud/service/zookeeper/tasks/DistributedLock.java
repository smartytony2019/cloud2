package com.xinbo.cloud.service.zookeeper.tasks;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class DistributedLock implements Lock, Watcher {


    private String root = "/locks";


    private int sessionTimeout = 3000;

    private CountDownLatch preLatch;
    private CountDownLatch curLatch = new CountDownLatch(1);

    private String lockName;

    private ZooKeeper zk;

    private String zNode;
    private String waitNode;



    public DistributedLock(String connectionString, String lockName)  {
        this.lockName = lockName;
        try {
            zk = new ZooKeeper(connectionString, sessionTimeout, this);
            curLatch.await();
            Stat stat = zk.exists(root, false);
            if(stat == null) {
                zk.create(root,new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
        } catch (IOException ex) {
            throw new LockException(ex);
        } catch (KeeperException ex) {
            throw new LockException(ex);
        }catch (InterruptedException ex) {
            throw new LockException(ex);
        }
    }




    @Override
    public void lock() {
        try {
            if(this.tryLock()){
                return;
            }
            this.waitForLock(waitNode, sessionTimeout);
        }catch (KeeperException ex) {
            throw new LockException(ex);
        } catch (InterruptedException ex) {
            throw new LockException(ex);
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        this.lock();
    }

    @Override
    public boolean tryLock() {
        try {

            String splitStr = "_lock_";
            if(this.lockName.contains(splitStr)) {
                throw new LockException("锁名不合法");
            }

            String path = String.format("%s/%s%s", this.root, this.lockName, splitStr);

            zNode = zk.create(path,new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

            List<String> subNodes = zk.getChildren(root,false);

            List<String> lockObjNodes = new ArrayList<>();
            for(String node : subNodes) {
                 String _node = node.split(splitStr)[0];
                 if(_node.equals(this.lockName)) {
                    lockObjNodes.add(_node);
                 }
            }


            Collections.sort(lockObjNodes);
            if(this.zNode.equals(this.root + "/"+lockObjNodes.get(0))) {
                return true;
            }

            String preZnode = zNode.substring(zNode.indexOf("/")+1);
            waitNode = subNodes.get(Collections.binarySearch(subNodes, preZnode) + 1);
        }catch (KeeperException ex) {
            throw new LockException(ex);
        } catch (InterruptedException ex) {
            throw new LockException(ex);
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit timeUnit){
        try {
            if(this.tryLock()) {
                return true;
            }
            this.waitForLock(this.waitNode, time);
        }catch (Exception ex) {
            throw new LockException(ex);
        }
        return false;
    }

    private boolean waitForLock(String node, long waitTime) throws InterruptedException, KeeperException {
        Stat stat = zk.exists(this.root+"/"+this.waitNode, true);
        if(stat != null) {
            this.preLatch = new CountDownLatch(1);
            this.preLatch.await(waitTime, TimeUnit.MILLISECONDS);
            this.preLatch = null;
        }
        return true;
    }


    @Override
    public void unlock() {
        System.out.println("unlock"+this.zNode);
        try {
            zk.delete(this.zNode, 1);
            zNode = null;
            zk.close();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {

    }


    public class LockException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public LockException(String e){
            super(e);
        }
        public LockException(Exception e){
            super(e);
        }
    }
}
