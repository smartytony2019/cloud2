package com.xinbo.cloud.common.service;

import com.xinbo.cloud.common.domain.User;
import com.xinbo.cloud.common.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {


    @Autowired
    private UserMapper userMapper;


    public User getOne(long id) {
        return userMapper.selectUserById(id);
    }

}
