package com.xinbo.cloud.common.mapper.common;

import com.xinbo.cloud.common.domain.common.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

@Mapper
public interface MerchantMapper extends MyMapper<Merchant> {

    @Select("select * from merchant where MerchantId=#{merchantId}")
    List<Merchant> Get(@Param("merchantId") long merchantId);

}
