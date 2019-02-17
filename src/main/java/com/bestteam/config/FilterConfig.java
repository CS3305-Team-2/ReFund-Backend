package com.bestteam.config;

import java.util.Arrays;
import java.util.List;

import com.bestteam.middleware.JWTAuth;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    private List<String> includes = Arrays.asList();

    @Bean
    public FilterRegistrationBean<JWTAuth> authFilter() {
        FilterRegistrationBean<JWTAuth> bean = new FilterRegistrationBean<>();
        bean.setFilter(new JWTAuth());
        bean.addUrlPatterns(includes.toArray(new String[]{}));
        return bean;
    }
}