package com.xinbo.cloud.service.cache.service;

import com.xinbo.cloud.service.cache.vo.ListVo;
import com.xinbo.cloud.service.cache.vo.SetVo;
import org.springframework.web.bind.annotation.PathVariable;

public interface RedisService {

    default Object get(String key) {
        return null;
    }

    void set(SetVo setVo);


    void push(ListVo listVo);
    

}
