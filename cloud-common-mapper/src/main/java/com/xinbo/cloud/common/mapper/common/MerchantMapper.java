package com.xinbo.cloud.common.mapper.common;

import com.github.pagehelper.PageInfo;
import com.xinbo.cloud.common.domain.common.Merchant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

@Mapper

public interface MerchantMapper extends MyMapper<Merchant> {

    /**
     * 根据字段获取多条数据
     * @param merchant
     * @return
     */
    @Select("select * from merchant where MerchantCode=#{merchant.MerchantCode}, MerchantName=#{merchant.MerchantName} limit 1")
    Merchant getByFields(@Param("merchant") Merchant merchant);


    @Select("select * from merchant where MerchantCode=#{merchant.MerchantCode}, MerchantName=#{merchant.MerchantName}")
    List<Merchant> getAllByField(@Param("merchant") Merchant merchant);

    /**
     * 获取结果集合
     * @param limit
     * @param order
     * @return
     */
    List<Merchant> getLimit(@Param("limit") int limit, @Param("order") String order);


    /**
     * 获取结果集合
     * @param merchant
     * @param limit
     * @param order
     * @return
     */
    List<Merchant> getLimitByMerchant(
            @Param("merchant") Merchant merchant,
            @Param("limit") int limit,
            @Param("order") String order
    );


    /**
     * 获取所有
     * @return
     */
    int updateFields(@Param("merchant") Merchant merchant);


    /**
     * 保存商户
     * @param merchant
     * @return
     */
    int save(@Param("merchant") Merchant merchant);
}
