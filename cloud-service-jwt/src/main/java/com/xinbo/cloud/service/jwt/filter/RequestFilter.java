package com.xinbo.cloud.service.jwt.filter;

import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Configuration
public class RequestFilter implements WebMvcConfigurer {


    @Value("${jwt2.header.key}")
    private String jwtHeaderKey;

    @Value("${jwt2.secret}")
    private String jwtSecret;

    @Value("${jwt2.ignore.url}")
    private String jwtIgnoreUrl;


    class JwtInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

            // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
            /*if (handler instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                JwtIgnore jwtIgnore = handlerMethod.getMethodAnnotation(JwtIgnore.class);
                if (jwtIgnore != null) {
                    return true;
                }
            }*/

            if (HttpMethod.OPTIONS.equals(request.getMethod())) {
                response.setStatus(HttpServletResponse.SC_OK);
                return true;
            }

//            final String authHeader = request.getHeader(JwtConstant.AUTH_HEADER_KEY);
            final String authHeader = request.getHeader(jwtHeaderKey);

            if (StringUtils.isEmpty(authHeader)) {
                // TODO 这里自行抛出异常
                log.info("===== 用户未登录, 请先登录 =====");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
                return false;
            }

            // 校验头格式校验
            if (!JwtUtils.validate(authHeader)) {
                // TODO 这里自行抛出异常
                log.info("===== token格式异常 =====");
                return false;
            }

            // token解析
            final String authToken = JwtUtils.getRawToken(authHeader);
            Claims claims = JwtUtils.parseToken(authToken, jwtSecret);
            if (claims == null) {
                log.info("===== token解析异常 =====");
                return false;
            }

            // 传递所需信息
            request.setAttribute("CLAIMS", claims);
            return true;

        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        }

        @Override
        public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        }
    }

    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] ignoreUrls =  StrUtil.split(jwtIgnoreUrl,",");
        registry.addInterceptor(jwtInterceptor()).excludePathPatterns(ignoreUrls).addPathPatterns("/**");
    }
}
