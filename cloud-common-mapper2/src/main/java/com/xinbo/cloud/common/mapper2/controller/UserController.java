package com.xinbo.cloud.common.mapper2.controller;

import com.xinbo.cloud.common.domain.User;
import com.xinbo.cloud.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page() {
//        User user = userService.getOne(1L);
//        UserService userService = new UserService();
        User user = userService.getOne(1L);
        return user.toString();
    }

}
