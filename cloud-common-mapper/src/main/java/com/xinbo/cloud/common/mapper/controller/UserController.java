package com.xinbo.cloud.common.mapper.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.xinbo.cloud.common.mapper.entity.UserEntity;
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

        UserEntity user = userMapper.selectUserById(1L);

        return "success"+user.toString();
    }

    @GetMapping("/del")
    public String del() {
        int id = userMapper.deleteById(1L);
        return "success:" +id;
    }


    @GetMapping("/add")
    public String add() {

        String salt = IdUtil.fastSimpleUUID();
        UserEntity user = UserEntity.builder().name("testSave3").password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave3@xkcoding.com").phoneNumber("17300000003").status(1).lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
        int i = userMapper.saveUser(user);

        return "success"+i;
    }


    @GetMapping("update")
    public String update() {
        String salt = IdUtil.fastSimpleUUID();
        UserEntity user = UserEntity.builder().id(3L).name("jack11111111").password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave3@xkcoding.com").phoneNumber("17300000003").status(1).lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
        int i = userMapper.updateById(user);
        return "success" + i;
    }

}
