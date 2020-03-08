package com.xinbo.cloud.common.service.impl;

import com.xinbo.cloud.common.domain.User;
import com.xinbo.cloud.common.mapper.UserMapper;
import com.xinbo.cloud.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

//    @Autowired
//    private UserMapper userMapper;

    public User getOne(long id) {
//        return userMapper.selectUserById(id);
        return new User();
    }
}
