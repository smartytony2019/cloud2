package com.xinbo.cloud.service.oauth.util;

import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.xinbo.cloud.service.oauth.config.JwtConfig;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;

import java.nio.file.attribute.UserPrincipal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Configuration
public class JwtUtil {


    public String createToken(Authentication authentication) {
        return this.createJwt(1L,"com.xinbo", Lists.newArrayList("1","2"), authentication.getAuthorities());
    }

    public String createJwt(Long id, String subject, List<String> roles, Collection<? extends GrantedAuthority> authorities) {
        Date now = new Date();
        JwtBuilder builder = Jwts.builder()
                .setId(id.toString())
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, "xkcoding")
                .claim("roles",roles)
                .claim("authorities", authorities);


        //builder.setExpiration(DateUtil.offsetMillisecond(now, 24 * 60 * 60 * 1000)) //设置过期时间

        return builder.compact();

    }

}
