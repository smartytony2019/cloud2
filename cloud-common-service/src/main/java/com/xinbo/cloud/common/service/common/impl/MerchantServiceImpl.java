package com.xinbo.cloud.common.service.common.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xinbo.cloud.common.domain.common.Merchant;
import com.xinbo.cloud.common.mapper.common.MerchantMapper;
import com.xinbo.cloud.common.service.common.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service("merchantServiceImpl")
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    /**
     * 获取单条
     * @param merchantId
     * @return
     */
    @Override
    public Merchant get(long merchantId) {
        return merchantMapper.selectByPrimaryKey(merchantId);
    }


    /**
     *
     * @param merchant
     * @return
     */
    @Override
    public Merchant getByFields(Merchant merchant) {
//        return merchantMapper.select(merchant).get(0);
        return merchantMapper.getByFields(merchant);
    }


    /**
     * 获取集合
     * @return
     */
    @Override
    public List<Merchant> getAll() {
        return merchantMapper.selectAll();
    }


    /**
     * 获取所有集合
     * @return
     */
    public List<Merchant> getAllByField(Merchant merchant) {
//        Example example = new Example(Merchant.class);
//        example.createCriteria().andEqualTo("Status", merchant.isStatus());
//        example.setOrderByClause("MerchantId desc, AddTime asc");
//        return merchantMapper.selectByExample(example);

        return merchantMapper.getAllByField(merchant);
    }

    /**
     * 获取集合(限制条数)
     * @return
     */
    @Override
    public List<Merchant> getLimit(int limit, String order) {
        return merchantMapper.getLimit(limit, order);
    }


    /**
     * 获获取集合(限制条数)
     * @return
     */
    @Override
    public List<Merchant> getLimitByMerchant(Merchant merchant, int limit, String order) {
        return merchantMapper.getLimitByMerchant(merchant, limit, order);
    }


    @Override
    public PageInfo<Merchant> page(Merchant merchant, int pageNum, int pageSize) {
        Example example = new Example(Merchant.class);
        example.createCriteria().andEqualTo("Status", merchant.isStatus());

        PageHelper.startPage(pageNum, pageSize);
        PageInfo<Merchant> pageInfo = new PageInfo<Merchant>(merchantMapper.selectByExample(example));
        return pageInfo;
    }


    /**
     * 添加
     * @param merchant
     * @return
     */
    @Override
    public int add(Merchant merchant) {
        return merchantMapper.insert(merchant);
    }


    /**
     * 更新整个字段
     * @param merchant
     * @return
     */
    public int update(Merchant merchant) {
        return merchantMapper.updateByPrimaryKey(merchant);
    }


    /**
     * 更新(某些字段)
     * @param merchant
     * @return
     */
    public int updateFields(Merchant merchant) {
        return merchantMapper.updateFields(merchant);
    }


    /**
     * 删除
     * @param merchantId 商户id
     * @return
     */
    public int delete(int merchantId) {
        return merchantMapper.deleteByPrimaryKey(merchantId);
    }


    /**
     * 删除
     * @param merchant 商户模型
     * @return
     */
    public int delete(Merchant merchant) {
        return merchantMapper.delete(merchant);
    }

}
