package com.xinbo.cloud.service.cache.controller;

import com.xinbo.cloud.common.dto.ActionResult;
import com.xinbo.cloud.common.vo.common.SetVo;
import com.xinbo.cloud.service.cache.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cache")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("set")
    public String set(@RequestBody SetVo setVo) {
        redisService.set(setVo.getKey(), setVo.getValue());
        return "ok";
    }

    @GetMapping("get/{key}")
    public Object get(@PathVariable String key) {
        return redisService.get(key);
    }

}
