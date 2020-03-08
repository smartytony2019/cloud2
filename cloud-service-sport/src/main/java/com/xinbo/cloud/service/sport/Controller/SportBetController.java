package com.xinbo.cloud.service.sport.Controller;


import com.xinbo.cloud.common.dto.ResponseResult;
import com.xinbo.cloud.common.dto.ResultFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sport")
public class SportBetController {


    @GetMapping("submit")
    public ResponseResult Submit() {

        StringBuffer sb = new StringBuffer();
        Colors[] colors = Colors.values();
        for(Colors c : colors) {
            sb.append(c + " -- " + c.code+" -- "+c.msg);
        }

        sb.append("-----------------");

        int i = 2;
        Colors c =  Colors.valueOf(i);
        sb.append(c + " -- " + c.code+" -- "+c.msg);

        if(c == Colors.RED) {
            sb.append("这是红色");
        } else {
            sb.append("这不是红色");
        }

        return ResultFactory.Success(sb);
    }

    @NoArgsConstructor
    @AllArgsConstructor
    public enum Colors {
        RED(1,"红色"),
        BLUE(2, "绿色"),
        WHITE(3,"白色");

        Integer code;
        String msg;
        public static Colors valueOf(Integer code) {
            switch (code) {
                case 1:
                    return RED;
                case 2:
                    return BLUE;
                case 3:
                    return WHITE;
                default:
                    return null;
            }
        }
    }


}
