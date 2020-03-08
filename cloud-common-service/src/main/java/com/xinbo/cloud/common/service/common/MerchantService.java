package com.xinbo.cloud.common.service.common;

import com.xinbo.cloud.common.domain.common.Merchant;

import java.util.List;

public interface MerchantService {


    List<Merchant> get(long merchantId);

}
