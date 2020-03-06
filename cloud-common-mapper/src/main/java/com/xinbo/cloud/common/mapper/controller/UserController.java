package com.xinbo.cloud.common.mapper.controller;

import com.xinbo.cloud.common.mapper.entity.Animal;
import com.xinbo.cloud.common.mapper.entity.User;
import com.xinbo.cloud.common.mapper.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;


    @GetMapping("/all")
    public String all() {

        User user = userMapper.selectUserById(1L);

        return "success"+user.toString();
    }

    @GetMapping("/del")
    public String del() {
        int id = userMapper.deleteById(1L);
        return "success:" +id;
    }


    @GetMapping("/add")
    public String add() {
        return "success";
    }
}
