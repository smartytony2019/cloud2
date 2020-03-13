package com.xinbo.cloud.service.jwt.filter;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Builder
public class JwtParam {

    /**
     * 发行者名
     */
    private String subject;

    /**
     * base64加密密钥
     */
    private String secret;

    /**
     * jwt中过期时间设置(分)
     */
    private int expires;

}
