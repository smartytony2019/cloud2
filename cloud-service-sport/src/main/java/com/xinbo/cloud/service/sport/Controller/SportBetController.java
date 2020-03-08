package com.xinbo.cloud.service.sport.Controller;


import com.xinbo.cloud.common.api.Api;
import com.xinbo.cloud.common.api.Status;
import com.xinbo.cloud.common.dto.ResponseResult;
import com.xinbo.cloud.common.dto.ResultFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sport")
public class SportBetController {


    @GetMapping("submit")
    public ResponseResult Submit() {

        return ResultFactory.Success();

    }

}
