package com.vedeng.template.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Description: 拦截器配置
 * @author: Wyatt
 * @Date: 2019-06-12 19:17
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(WebConfiguration.class);

    @Autowired
    private GlobalViewVariablesHandlerInterceptor globalViewVariablesHandlerInterceptor;

    @Bean
    public WebMvcConfigurer WebMvcConfigurer() {
        return new WebMvcConfigurer() {
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(globalViewVariablesHandlerInterceptor);
            }
        };
    }



}

