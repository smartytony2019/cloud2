package com.xinbo.cloud.service.cache.service.impl;

import com.xinbo.cloud.service.cache.service.RedisService;
import com.xinbo.cloud.service.cache.vo.ListVo;
import com.xinbo.cloud.service.cache.vo.SetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {


    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    @Override
    public void set(SetVo setVo) {
        if(setVo.getExpire() > 0) {
            redisTemplate.opsForValue().set(setVo.getKey(), setVo.getValue(), setVo.getExpire(), TimeUnit.SECONDS);
        } else {
            redisTemplate.opsForValue().set(setVo.getKey(), setVo.getValue());
        }
    }


    @Override
    public void push(ListVo listVo) {
        redisTemplate.opsForList().leftPush(listVo.getKey(), listVo.getValue());
    }


    public long size(String key) {
        long size = redisTemplate.opsForList().size(key);
        return size;
    }


    public Object listAll(String key) {
        Object object = redisTemplate.opsForList().range(key, 0, this.size(key));
        return object;
    }




}
