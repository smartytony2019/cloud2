package com.xinbo.cloud.service.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("/set")
    public String set() {

        // key序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //val实例化
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        redisTemplate.opsForValue().set("aaaa","bbbbbbb");
        redisTemplate.opsForList().leftPush("TestList", "TestLeftPush");
        return "success";
    }

}
