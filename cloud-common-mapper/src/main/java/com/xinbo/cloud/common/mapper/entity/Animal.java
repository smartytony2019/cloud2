package com.xinbo.cloud.common.mapper.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter
@Getter
@ToString
public class Animal {
    private String species;
    private String ras;
}