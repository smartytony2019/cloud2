package com.xinbo.cloud.common.mapper2.controller;

import com.xinbo.cloud.common.mapper2.entity.UserEntity;
import com.xinbo.cloud.common.mapper2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;


@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page() {

        Example example = new Example(UserEntity.class);
        int count = userMapper.selectCountByExample(example);

        return "success"+ count;
    }

}
