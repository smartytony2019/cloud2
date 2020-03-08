package com.xinbo.cloud.common.api;

import java.io.Serializable;


public interface IResultCode extends Serializable {

    /**
     * 消息
     *
     * @return String
     */
    String getMsg();

    /**
     * 状态码
     *
     * @return int
     */
    int getCode();

}
