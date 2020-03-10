package com.xinbo.cloud.common.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RocketMessage<T> implements Serializable {

    private int messageId;

    private T messageBody;
}
