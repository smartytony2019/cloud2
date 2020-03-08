package com.xinbo.cloud.common.dto;


import com.xinbo.cloud.common.enums.ResponseCodeEnum;

/**
 * API返回结果类
 */
public class ResultFactory {


    public static ActionResult Success() {
        return ActionResult.builder().code(ResponseCodeEnum.SUCCESS.value()).build();
    }

    public static ActionResult Success(Object data) {
        return ActionResult.builder().code(ResponseCodeEnum.SUCCESS.value()).data(data).build();
    }

    public static ActionResult Success(Object data, String msg) {
        return ActionResult.builder().code(ResponseCodeEnum.SUCCESS.value()).data(data).msg(msg).build();
    }


    public static ActionResult Error() {
        return ActionResult.builder().code(ResponseCodeEnum.FAILURE.value()).build();
    }

    public static ActionResult Error(Object data) {
        return ActionResult.builder().code(ResponseCodeEnum.FAILURE.value()).data(data).build();
    }

    public static ActionResult Error(Object data, String msg) {
        return ActionResult.builder().code(ResponseCodeEnum.FAILURE.value()).data(data).msg(msg).build();
    }
}
