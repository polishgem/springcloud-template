package com.vedeng.template.web.interceptor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 模板全局变量设置
 * @author: Wyatt
 * @Date: 2019-06-12 19:05
 */
@Component
public class GlobalViewVariablesHandlerInterceptor implements HandlerInterceptor {

    /**
     * 前后端分离静态资源版本号
     */
    @Value("${staticResourcesVersion}")
    private String staticResourcesVersion;


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        request.setAttribute("staticResourcesVersion", staticResourcesVersion);
    }
}

