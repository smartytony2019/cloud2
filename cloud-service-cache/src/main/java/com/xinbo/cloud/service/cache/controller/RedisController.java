package com.xinbo.cloud.service.cache.controller;

import com.alibaba.fastjson.JSON;
import com.xinbo.cloud.service.cache.service.RedisService;
import com.xinbo.cloud.service.cache.vo.ListVo;
import com.xinbo.cloud.service.cache.vo.SetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("cache")
public class RedisController {

    @Autowired
    private RedisService redisService;


    @PostMapping("get")
    public String get(@RequestBody String key) {
        return JSON.toJSONString(redisService.get(key));
    }


    @PostMapping("set")
    public void set(@Valid @RequestBody SetVo setVo) {
        redisService.set(setVo);
    }


    public void push(@RequestBody ListVo listVo) {
        redisService.push(listVo);
    }


}
