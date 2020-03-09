package com.xinbo.cloud.common.dto;


import com.xinbo.cloud.common.enums.ResponseCodeEnum;

/**
 * API返回结果类
 */
public class ResultFactory {


    public static ActionResult success() {
        return ActionResult.builder().code(ResponseCodeEnum.SUCCESS.value()).build();
    }

    public static ActionResult success(Object data) {
        return ActionResult.builder().code(ResponseCodeEnum.SUCCESS.value()).data(data).build();
    }

    public static ActionResult success(Object data, String msg) {
        return ActionResult.builder().code(ResponseCodeEnum.SUCCESS.value()).data(data).msg(msg).build();
    }


    public static ActionResult error() {
        return ActionResult.builder().code(ResponseCodeEnum.FAILURE.value()).build();
    }

    public static ActionResult error(Object data) {
        return ActionResult.builder().code(ResponseCodeEnum.FAILURE.value()).data(data).build();
    }

    public static ActionResult error(Object data, String msg) {
        return ActionResult.builder().code(ResponseCodeEnum.FAILURE.value()).data(data).msg(msg).build();
    }
}
