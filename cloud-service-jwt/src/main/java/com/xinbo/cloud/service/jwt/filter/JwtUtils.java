package com.xinbo.cloud.service.jwt.filter;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.*;

/**
 * JWT工具类
 * Created by Hilox on 2018/11/16 0016.
 */
@Slf4j
public class JwtUtils {

    private static final String AUTHORIZATION_HEADER_PREFIX = "Bearer ";

    // 构造私有
    private JwtUtils() {}

    /**
     * 获取原始token信息
     * @param authorizationHeader 授权头部信息
     * @return
     */
    public static String getRawToken(String authorizationHeader) {
        return authorizationHeader.substring(AUTHORIZATION_HEADER_PREFIX.length()).trim();
    }

    /**
     * 获取授权头部信息
     * @param rawToken token信息
     * @return
     */
    public static String getAuthorizationHeader(String rawToken) {
        return AUTHORIZATION_HEADER_PREFIX + rawToken;
    }

    /**
     * 校验授权头部信息格式合法性
     * @param authorizationHeader 授权头部信息
     * @return
     */
    public static boolean validate(String authorizationHeader) {
        return StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith(AUTHORIZATION_HEADER_PREFIX);
    }

    /**
     * 生成token, 只在用户登录成功以后调用
     * @param userId 用户id
     * @param jwtParam JWT加密所需信息
     * @return
     */
//    public static String createToken(String userId, JwtParam jwtParam) {
//        return createToken(userId, null, jwtParam);
//    }

    /**
     * 生成token, 只在用户登录成功以后调用
     * @param claim 声明
     * @param jwtParam JWT加密所需信息
     * @return
     */
    public static String createToken(Map<String, Object> claim, JwtParam jwtParam) {
        try {
            // 使用HS256加密算法
            SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);

            // 生成签名密钥
            byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(jwtParam.getSecret());
            SecretKeySpec signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

            // 添加构成JWT的参数
            JwtBuilder jwtBuilder = Jwts.builder().setHeaderParam("typ", "JWT")
//                    .claim(JwtConstant.USER_ID_KEY, userId)
                    .addClaims(claim)
                    .setSubject(jwtParam.getSubject())
                    .setIssuedAt(now)
                    .signWith(signatureAlgorithm, signingKey);

            // 添加token过期时间
            long TTLMillis = jwtParam.getExpires() * 60 * 1000;
            if (TTLMillis >= 0) {
                long expMillis = nowMillis + TTLMillis;
                Date exp = new Date(expMillis);
                jwtBuilder.setExpiration(exp).setNotBefore(now);
            }

            return jwtBuilder.compact();
        } catch (Exception e) {
            // TODO 这里自行抛出异常
            log.error("签名失败", e);
            return null;
        }
    }

    /**
     * 解析token
     * @param authToken 授权头部信息
     * @param base64Secret base64加密密钥
     * @return
     */
    public static Claims parseToken(String authToken, String base64Secret) {
        try{
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret))
                    .parseClaimsJws(authToken).getBody();
            return claims;
        } catch (SignatureException se) {
            // TODO 这里自行抛出异常
            log.error("===== 密钥不匹配 =====", se);
        } catch (ExpiredJwtException ejw) {
            // TODO 这里自行抛出异常
            log.error("===== token过期 =====", ejw);
        } catch (Exception e){
            // TODO 这里自行抛出异常
            log.error("===== token解析异常 =====", e);
        }
        return null;
    }

    public static Map<String,Object> test(Claims claims) {
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

}
