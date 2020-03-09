package com.xinbo.cloud.common.service.platform.impl;

import com.xinbo.cloud.common.domain.platform.Merchant;
import com.xinbo.cloud.common.mapper.platform.MerchantMapper;
import com.xinbo.cloud.common.service.platform.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("merchantServiceImpl")
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public List<Merchant> get(long merchantId) {
        return merchantMapper.Get(merchantId);
    }
}
