package com.xinbo.cloud.common.enums;

import cn.hutool.http.HttpStatus;
import com.xinbo.cloud.common.constant.ApiStatus;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum ResponseCodeEnum {

    SUCCESS(ApiStatus.SUCCESS,"成功"),
    FAILURE(ApiStatus.FAILURE, "失败"),
    UNAUTHORIZED(ApiStatus.UNAUTHORIZED,"未认证");

    Integer code;
    String msg;
    public static ResponseCodeEnum valueOf(int code) {
        switch (code) {
            case ApiStatus.SUCCESS:
                return SUCCESS;
            case ApiStatus.FAILURE:
                return FAILURE;
            case ApiStatus.UNAUTHORIZED:
                return UNAUTHORIZED;
            default:
                return null;
        }
    }

    public int value() {
        return this.code;
    }
}
