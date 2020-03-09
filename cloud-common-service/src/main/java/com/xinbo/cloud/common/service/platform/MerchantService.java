package com.xinbo.cloud.common.service.platform;

import com.xinbo.cloud.common.domain.platform.Merchant;

import java.util.List;

public interface MerchantService {


    List<Merchant> get(long merchantId);

}
