package com.xinbo.cloud.common.mapper2.mapper;

import com.xinbo.cloud.common.mapper2.entity.UserEntity;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

@Component
public interface UserMapper extends Mapper<UserEntity>, MySqlMapper<UserEntity> {



}
