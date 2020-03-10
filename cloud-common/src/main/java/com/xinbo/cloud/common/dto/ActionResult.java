package com.xinbo.cloud.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActionResult {

    /**
     * 状态码
     */
    private int code;

    /**
     * 数据
     */
    private Object data;

    /**
     * 消息
     */
    private String msg;

    /**
     * 详情(异常信息)
     */
    private String detail;

}
