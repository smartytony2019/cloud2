package com.xinbo.cloud.common.dto;


public class ResultFactory {


    public static ResponseResult Success() {

        return ResponseResult.builder().code(0).build();
    }

    public static ResponseResult Success(Object data) {

        return ResponseResult.builder().data(data).build();
    }

    public static ResponseResult Success(Object data, String msg) {
        return ResponseResult.builder().code(0).data(data).msg(msg).build();
    }
}
