package com.xinbo.cloud.service.jwt.controller;

import cn.hutool.core.collection.CollUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.common.collect.Lists;
import com.xinbo.cloud.service.jwt.filter.JwtIgnore;
import com.xinbo.cloud.service.jwt.filter.JwtParam;
import com.xinbo.cloud.service.jwt.filter.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {


    @Value("${jwt2.secret}")
    private String secret;

    @Value("${jwt2.subject}")
    private String subject;

    @Value("${jwt2.expire}")
    private int expire;

    @Autowired
    private HttpServletRequest request;


    @GetMapping("login")
    public String login() {
        return "Success";
    }

    @GetMapping("login2")
    public String login2() {
        return "Success";
    }

    @JwtIgnore
    @GetMapping("generateToken")
    public String generateToken() {
        Integer userId = 5;
        // 2.验证通过生成token
        Map<String, Object> map = new HashMap<>();
        map.put("id",1);
        map.put("username", "jack");
        map.put("roles", Lists.newArrayList(1,2,3));


        JwtParam jwtParam = JwtParam.builder().subject(subject).secret(secret).expires(expire).build();

        String token = JwtUtils.createToken(map, jwtParam);
        return token;
    }


    @PostMapping("validToken")
    public boolean validToken() {
        boolean auth = false;

        return auth;
    }

    @PostMapping("getUserInfo")
    public String getUserInfo() {
        String authHeader = request.getHeader("Authorization");
        String tokenHead = "Bearer ";

        String token = authHeader.substring(tokenHead.length());

        Claims claims = JwtUtils.parseToken(token, secret);

        Map<String,Object> map = JwtUtils.test(claims);


        return "success";
    }

}
