package com.xinbo.cloud.service.sport.Controller;

import com.xinbo.cloud.common.Util.MapperUtil;
import com.xinbo.cloud.common.domain.common.Merchant;
import com.xinbo.cloud.common.dto.PageDto;
import com.xinbo.cloud.common.dto.common.MerchantDto;
import com.xinbo.cloud.common.dto.ActionResult;
import com.xinbo.cloud.common.Util.ResultFactory;
import com.xinbo.cloud.common.service.common.MerchantService;
import com.xinbo.cloud.common.vo.common.MerchantVo;
import io.swagger.annotations.ApiOperation;
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
    public ActionResult get(@RequestParam(name="merchantId") long merchantId) {
        Merchant merchant = merchantService.get(merchantId);
        MerchantDto dto = MapperUtil.to(merchant, MerchantDto.class);
        return ResultFactory.success(dto);
    }


    /**
     * 获取集合
     * @return
     */
    @ApiOperation(value = "获取集合", notes = "")
    @GetMapping("list")
    public ActionResult list() {

        List<Merchant> list = merchantService.getAll();
        List<MerchantDto> dtos = MapperUtil.many(list,MerchantDto.class);
        return ResultFactory.success(dtos);
    }


    @ApiOperation(value = "添加商户", notes = "")
    @PostMapping("save")
    public ActionResult save(@RequestBody MerchantVo merchantVo) {
        Merchant merchant = MapperUtil.to(merchantVo, Merchant.class);
        int result = merchantService.add(merchant);
        return result > 0 ? ResultFactory.success() : ResultFactory.error();
    }


    @ApiOperation(value = "分页", notes = "")
    @PostMapping("page")
    public ActionResult page() {
        Merchant merchant = Merchant.builder().Status(true).build();
        PageDto<MerchantDto> pageinfo =  merchantService.page(merchant, 1, 2);
        return ResultFactory.success(pageinfo);
    }



    public ActionResult update() {

//        merchantService.update();
        return ResultFactory.success();
    }


}
