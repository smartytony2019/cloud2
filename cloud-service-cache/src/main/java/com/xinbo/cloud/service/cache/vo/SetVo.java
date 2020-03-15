package com.xinbo.cloud.service.cache.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SetVo {

    @NotEmpty(message = "key不能为空")
    private String key;

    @NotEmpty(message = "value不能为空")
    private Object value;

    @Min(value = -1, message = "不能小于-1")
    private int expire;

}
