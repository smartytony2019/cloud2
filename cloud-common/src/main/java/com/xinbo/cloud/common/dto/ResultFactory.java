package com.xinbo.cloud.common.dto;


import com.xinbo.cloud.common.enums.ResponseCodeEnum;

/**
 * API返回结果类
 */
public class ResultFactory {


    public static ResponseResult Success() {
        return ResponseResult.builder().code(ResponseCodeEnum.SUCCESS.value()).build();
    }

    public static ResponseResult Success(Object data) {
        return ResponseResult.builder().code(ResponseCodeEnum.SUCCESS.value()).data(data).build();
    }

    public static ResponseResult Success(Object data, String msg) {
        return ResponseResult.builder().code(ResponseCodeEnum.SUCCESS.value()).data(data).msg(msg).build();
    }


    public static ResponseResult Error() {
        return ResponseResult.builder().code(ResponseCodeEnum.FAILURE.value()).build();
    }

    public static ResponseResult Error(Object data) {
        return ResponseResult.builder().code(ResponseCodeEnum.FAILURE.value()).data(data).build();
    }

    public static ResponseResult Error(Object data, String msg) {
        return ResponseResult.builder().code(ResponseCodeEnum.FAILURE.value()).data(data).msg(msg).build();
    }
}
