package com.xinbo.cloud.common.service.common;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.xinbo.cloud.common.domain.common.Merchant;
import com.xinbo.cloud.common.dto.PageDto;
import com.xinbo.cloud.common.dto.common.MerchantDto;

import java.util.List;

public interface MerchantService {


    /**
     * 获取单条数据
     * @param merchantId
     * @return
     */
    Merchant get(long merchantId);


    /**
     * 获取单条数据
     * @param merchant
     * @return
     */
    Merchant getByFields(Merchant merchant);


    /**
     * 获取所有集合
     * @return
     */
    List<Merchant> getAll();

    /**
     * 获取所有集合
     * @return
     */
    List<Merchant> getAllByField(Merchant merchant);

    /**
     * 获取集合(限制条数)
     * @param limit 条数
     * @param order 排序
     * @return
     */
    List<Merchant> getLimit(int limit, String order);

    /**
     * 获取集合(限制条数)
     * @param merchant
     * @param limit
     * @param order
     * @return
     */
    List<Merchant> getLimitByMerchant(Merchant merchant, int limit, String order);


    /**
     * 分页
     * @param merchant 实休条件
     * @param pageNum   页码
     * @param pageSize  条数
     * @return
     */
    PageDto<MerchantDto> page(Merchant merchant, int pageNum, int pageSize);

    /**
     * 保存
     * @param merchant
     * @return
     */
    int add(Merchant merchant);


    /**
     * 修改
     * @param merchant
     * @return
     */
    int update(Merchant merchant);


    /**
     * 更新(某个字段)
     * @param merchant
     * @return
     */
    int updateFields(Merchant merchant);


    /**
     * 删除
     * @param merchantId 商户id
     * @return
     */
    int delete(int merchantId);

    /**
     * 删除
     * @param merchant 商户模型
     * @return
     */
    int delete(Merchant merchant);
}
