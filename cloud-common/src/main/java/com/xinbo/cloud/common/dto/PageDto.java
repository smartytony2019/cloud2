package com.xinbo.cloud.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDto<T> {

    /**
     * 总条数
     */
    private long total;

    /**
     * 数据
     */
    private List<T> list;

}
