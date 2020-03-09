package com.xinbo.cloud.service.sport.Controller;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.pagehelper.PageInfo;
import com.xinbo.cloud.common.Util.MapperUtil;
import com.xinbo.cloud.common.domain.common.Merchant;
import com.xinbo.cloud.common.dto.platform.MerchantDto;
import com.xinbo.cloud.common.dto.ActionResult;
import com.xinbo.cloud.common.dto.ResultFactory;
import com.xinbo.cloud.common.service.common.MerchantService;
import com.xinbo.cloud.common.vo.common.MerchantVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant")
public class MerchantController {


    @Autowired
    @Qualifier("merchantServiceImpl")
    private MerchantService merchantService;

    /**
     * 获取单条数据
     * @return
     */
    @ApiOperation(value = "获取商户", notes = "")
    @GetMapping("get")
    public ActionResult get() {
        long merchantId = 1230835262695804929L;
        List<Merchant> list = merchantService.get(merchantId);
        Merchant merchant = list.get(0);
        MerchantDto dto = MapperUtil.to(merchant, MerchantDto.class);
        return ResultFactory.Success(dto);
    }


    /**
     * 获取集合
     * @return
     */
    @ApiOperation(value = "获取集合", notes = "")
    @GetMapping("list")
    public ActionResult list() {
        long merchantId = 1230835262695804929L;
        List<Merchant> list = merchantService.get(merchantId);
        Merchant merchant = list.get(0);
        MerchantDto dto = MapperUtil.to(merchant, MerchantDto.class);
        return ResultFactory.Success(dto);
    }


    @ApiOperation(value = "添加商户", notes = "")
    @PostMapping("save")
    public ActionResult save(@RequestBody MerchantVo merchantVo) {
        Merchant merchant = MapperUtil.to(merchantVo, Merchant.class);
        int result = merchantService.save(merchant);
        return result > 0 ? ResultFactory.Success() : ResultFactory.Error();
    }


    @ApiOperation(value = "分页", notes = "")
    @PostMapping("page")
    public ActionResult page() {
        Merchant merchant = Merchant.builder().Status(true).build();
        PageInfo<Merchant> pageinfo =  merchantService.page(merchant, 1, 2);
        return ResultFactory.Success(pageinfo);
    }


    public ActionResult update() {
        merchantService.update();
    }


}
