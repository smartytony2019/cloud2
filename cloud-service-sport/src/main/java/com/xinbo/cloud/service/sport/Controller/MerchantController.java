package com.xinbo.cloud.service.sport.Controller;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.xinbo.cloud.common.domain.platform.Merchant;
import com.xinbo.cloud.common.dto.platform.MerchantDto;
import com.xinbo.cloud.common.dto.ActionResult;
import com.xinbo.cloud.common.dto.ResultFactory;
import com.xinbo.cloud.common.service.platform.MerchantService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("merchant")
public class MerchantController {


    @Autowired
    @Qualifier("merchantServiceImpl")
    private MerchantService merchantService;

    @ApiOperation("商户")
    @GetMapping("get")
    public ActionResult get() {
        long merchantId = 1230835262695804929L;
        List<Merchant> list = merchantService.get(merchantId);

        Merchant merchant = list.get(0);
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        MerchantDto dto = mapper.map(merchant, MerchantDto.class);

        return ResultFactory.Success(dto);
    }

}
