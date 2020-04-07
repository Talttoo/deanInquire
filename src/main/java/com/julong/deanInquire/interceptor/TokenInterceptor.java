package com.julong.deanInquire.interceptor;

import com.julong.deanInquire.utils.other.TokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义token拦截器
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {
    private static final Logger log = LoggerFactory.getLogger(TokenInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if (token != null){
            boolean result = TokenUtil.parseJWT(token);
            if(result){
               // System.out.println("通过拦截器");
                log.info("通过拦截器");
                return true;
            }
        }
       // System.out.println("认证失败");
        log.error("认证失败");
        response.getWriter().write("50000");
        return false;
    }
}
