package com.xinbo.cloud.common.service;

import com.xinbo.cloud.common.domain.User;
import com.xinbo.cloud.common.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.MyMapper;

public interface UserService {

    User getOne(long id);

}
