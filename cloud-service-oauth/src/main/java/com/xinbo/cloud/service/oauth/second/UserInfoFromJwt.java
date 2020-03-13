package com.xinbo.cloud.service.oauth.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class UserInfoFromJwt {


    @Autowired
    private HttpServletRequest request;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    public String userName() {
        String authHeader = request.getHeader("Authorization");
        String tokenHead = "Bearer ";

        String authToken = authHeader.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        return username;

    }

    public Map<String,Object> test() {
        String authHeader = request.getHeader("Authorization");
        String tokenHead = "Bearer ";

        String token = authHeader.substring(tokenHead.length());
        Map<String,Object> map = jwtTokenUtil.test(token);
        return map;

    }
}
