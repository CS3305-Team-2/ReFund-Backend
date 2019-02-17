package com.bestteam.config;

import com.bestteam.middleware.JWTAuth;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean<JWTAuth> authFilter() {
        FilterRegistrationBean<JWTAuth> bean = new FilterRegistrationBean<>();
        bean.setFilter(new JWTAuth());
        return bean;
    }
}