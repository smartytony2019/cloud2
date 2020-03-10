package com.xinbo.cloud.common.Util;


import com.xinbo.cloud.common.dto.ActionResult;
import com.xinbo.cloud.common.enums.ResponseCodeEnum;

/**
 * API返回结果类
 */
public class ResultFactory {

    /**
     * 成功
     * @return
     */
    public static ActionResult success() {
        return ActionResult.builder().code(ResponseCodeEnum.SUCCESS.value()).build();
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static ActionResult success(Object data) {
        return ActionResult.builder().code(ResponseCodeEnum.SUCCESS.value()).data(data).build();
    }



    /**
     * 失败
     * @return
     */
    public static ActionResult error() {
        return ActionResult.builder().code(ResponseCodeEnum.FAILURE.value()).build();
    }

    /**
     * 失败
     * @param msg   失败内容
     * @return
     */
    public static ActionResult error(String msg) {
        return ActionResult.builder().code(ResponseCodeEnum.FAILURE.value()).msg(msg).build();
    }
}
