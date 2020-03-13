package com.xinbo.cloud.service.oauth.second;

import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Lists;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -2550185165626007488L;

    public static final long JWT_TOKEN_VALIDITY = 5*60*60;

    @Value("${jwt.secret}")
    private String secret;

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public long getUserId(String token) throws Exception {
        String tmp = getClaimFromToken(token, Claims::getId);
        if(StrUtil.isEmpty(tmp)) {
            throw new Exception("userid not foud");
        }
        return Long.parseLong(tmp);
    }

    public Date getIssuedAtDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getIssuedAt);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }


    public Map<String,Object> test(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        Optional<Claims> optional = Optional.of(claims);
        if(optional.isPresent()){
            Map<String,Object> info = new HashMap<String,Object>();
            Set<String> keySet = optional.get().keySet();
            //通过迭代，提取token中的参数信息
            Iterator<String> iterator = keySet.iterator();
            while(iterator.hasNext()){
                String key = iterator.next();
                Object value =  optional.get().get(key);
                info.put(key,value);
            }
            return info;
        }
        return null;
    }


    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean ignoreTokenExpiration(String token) {
        // here you specify tokens, for that the expiration is ignored
        return false;
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("subject", userDetails.getUsername());
        claims.put("roles", Lists.newArrayList(1,2,3,4));
        return doGenerateToken(claims);
    }

    private String doGenerateToken(Map<String, Object> claims) {

        String id = claims.get("id").toString();
        String subject = claims.get("subject").toString();

        return Jwts.builder().setClaims(claims).setId(id).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY*1000)).signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public Boolean canTokenBeRefreshed(String token) {
        return (!isTokenExpired(token) || ignoreTokenExpiration(token));
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
