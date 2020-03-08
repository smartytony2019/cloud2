package com.xinbo.cloud.common.service.common.impl;

import com.xinbo.cloud.common.domain.common.Merchant;
import com.xinbo.cloud.common.mapper.common.MerchantMapper;
import com.xinbo.cloud.common.service.common.MerchantService;
import io.swagger.annotations.Authorization;
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
