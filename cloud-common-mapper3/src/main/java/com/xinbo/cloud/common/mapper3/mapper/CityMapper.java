package com.xinbo.cloud.common.mapper3.mapper;

import com.xinbo.cloud.common.mapper3.model.City;
import com.xinbo.cloud.common.mapper3.util.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CityMapper extends MyMapper<City> {

    /**
     * 根据id查询用户
     *
     * @param id 主键id
     * @return 当前id的用户，不存在则是 {@code null}
     */
    @Select("SELECT * FROM orm_user WHERE id = #{id}")
    City selectUserById(@Param("id") Long id);

}
