package com.xinbo.cloud.service.cache.service.impl;

import com.xinbo.cloud.service.cache.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {


    @Autowired
    private RedisTemplate redisTemplate;
    /*public void get(String key) {

        // key序列化
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //val实例化
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        redisTemplate.opsForValue().set("aaaa","bbbbbbb");
        redisTemplate.opsForValue().get(key);
        redisTemplate.opsForList().leftPush("TestList", "TestLeftPush");
    }*/

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void set(String key, Object value, int second) {
        redisTemplate.opsForValue().set(key,value, second, TimeUnit.SECONDS);
    }
}
