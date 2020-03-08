package com.xinbo.cloud.service.sport.Controller;


import com.xinbo.cloud.common.dto.ActionResult;
import com.xinbo.cloud.common.dto.ResultFactory;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sport")
public class SportBetController {

    @ApiOperation("提交注单")
    @GetMapping("submit")
    public ActionResult Submit() {
        return ResultFactory.Success();
    }

}
