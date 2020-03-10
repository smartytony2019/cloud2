package com.xinbo.cloud.service.sport.Controller;


import com.xinbo.cloud.common.Util.MapperUtil;
import com.xinbo.cloud.common.domain.common.User;
import com.xinbo.cloud.common.dto.ActionResult;
import com.xinbo.cloud.common.Util.ResultFactory;
import com.xinbo.cloud.common.vo.common.UserVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.xinbo.cloud.common.dto.common.UserDto;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("sport")
public class SportBetController {

    @ApiOperation("提交注单")
    @GetMapping("submit")
    public ActionResult Submit() {
        return ResultFactory.success();
    }

    @ApiOperation("test")
    @PostMapping("test")
    public ActionResult Test(@RequestBody UserVo userVO) {

        return ResultFactory.success(userVO);
    }

    @GetMapping("test2/{username}/{password}")
    public ActionResult Test2(@PathVariable String username, @PathVariable String password) {


        User user = User.builder().name("jack").password("123").email("123456").build();
        UserDto dto = MapperUtil.to(user, UserDto.class);


        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        map.put("password", password);
        return ResultFactory.success(dto);
    }

}
