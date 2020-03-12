package com.xinbo.cloud.service.oauth.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Autowired
//    private UserMapper userMapper;
//    @Autowired
//    private RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查数据库
//        User user = userMapper.loadUserByUsername( userName );
//        if (null != user) {
//            List<Role> roles = roleMapper.getRolesByUserId( user.getId() );
//            user.setAuthorities( roles );
//        }

        User user = new User();
        user.setId(1L);
        user.setUsername("admin");
        user.setPassword("123456");

        return user;
    }
}