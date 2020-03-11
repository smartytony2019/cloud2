package com.xinbo.cloud.service.oauth.model;


import lombok.Data;

@Data
public class LoginRequest {

    /**
     * 用户名或邮箱或手机号
     */
    private String usernameOrEmailOrPhone;

    /**
     * 密码
     */
    private String password;

    /**
     * 记住我
     */
    private Boolean rememberMe = false;

}