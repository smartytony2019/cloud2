package com.xinbo.cloud.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum ResultCode implements IResultCode {

    /**
     * 操作成功
     */
    SUCCESS(IResponseCode.SUCCESS, "操作成功"),

    /**
     * 业务异常
     */
    FAILURE(IResponseCode.FAILURE, "业务异常"),

    /**
     * 请求未授权
     */
    UN_AUTHORIZED(IResponseCode.UNAUTHORIZED, "请求未授权"),

    ;

    /**
     * code编码
     */
    int code;
    /**
     * 中文信息描述
     */
    String msg;

}
