package com.xinbo.cloud.service.cache.service;

import org.springframework.web.bind.annotation.PathVariable;

public interface RedisService {

    default Object get(String key) {
        return null;
    }

    void set(String key, Object value);

    void set(String key, Object value, int second);


    

}
