package com.xinbo.cloud.common.service.common.impl;

import com.xinbo.cloud.common.domain.common.User;
import com.xinbo.cloud.common.service.common.UserService;
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
