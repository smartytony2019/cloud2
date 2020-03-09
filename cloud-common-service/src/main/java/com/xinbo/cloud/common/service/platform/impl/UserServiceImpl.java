package com.xinbo.cloud.common.service.platform.impl;

import com.xinbo.cloud.common.domain.platform.User;
import com.xinbo.cloud.common.service.platform.UserService;
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
