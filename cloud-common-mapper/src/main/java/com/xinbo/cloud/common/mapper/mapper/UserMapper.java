package com.xinbo.cloud.common.mapper.mapper;

import com.xinbo.cloud.common.mapper.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {


    /**
     * 根据id查询用户
     *
     * @param id 主键id
     * @return 当前id的用户，不存在则是 {@code null}
     */
    @Select("SELECT * FROM orm_user WHERE id = #{id}")
    UserEntity selectUserById(@Param("id") Long id);

    /**
     * 删除用户
     *
     * @param id 主键id
     * @return 成功 - {@code 1} 失败 - {@code 0}
     */
    int deleteById(@Param("id") Long id);

    /**
     * 修改数据
     * @param user
     * @return
     */
    int updateById(@Param("user") UserEntity user);

    /**
     * 添加
     * @param user
     * @return
     */
    int saveUser(@Param("user") UserEntity user);

}
