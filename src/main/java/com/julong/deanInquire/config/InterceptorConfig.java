package com.julong.deanInquire.config;

import com.julong.deanInquire.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private TokenInterceptor tokenInterceptor;

    public InterceptorConfig(TokenInterceptor tokenInterceptor) {
        this.tokenInterceptor = tokenInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePath = new ArrayList<>();
        String sysUserLogin = "/user/login";
        String unLogin1 = "/user/logout";
        excludePath.add(sysUserLogin);
        excludePath.add(unLogin1);
        registry.addInterceptor(tokenInterceptor).excludePathPatterns(excludePath);
    }

}
