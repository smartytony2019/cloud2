package com.xinbo.cloud.service.cache.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListVo {

    @NotEmpty(message = "key不能为空")
    private String key;

    @NotEmpty(message = "value不能为空")
    private List<Object> value;

    @Min(value = -1, message = "不能小于-1")
    private int expire;

}
