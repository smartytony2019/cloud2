package com.xinbo.cloud.service.zookeeper;

import com.xinbo.cloud.service.zookeeper.tasks.DistributedLock;
import com.xinbo.cloud.service.zookeeper.tasks.DistributedLock2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;

public class CloudZookeeperApplication {
    static int n = 20;

    @Async
    public static void secskill() {
        if(n == 0) {
            return;
        }
        System.out.println("  库存为-->  "+--n);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                DistributedLock2 lock = null;
                try {
                    lock = new DistributedLock2("192.168.1.100:2181,192.168.1.100:2182,192.168.1.100:2183", "test");
                    lock.lock();
                    secskill();
                    System.out.println(Thread.currentThread().getName() + "正在运行");
                } finally {
                    if (lock != null) {
                        lock.unlock();
                    }
                }
            }
        };

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
