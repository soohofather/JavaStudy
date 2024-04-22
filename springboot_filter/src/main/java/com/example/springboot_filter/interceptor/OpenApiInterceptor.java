package com.example.springboot_filter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class OpenApiInterceptor implements HandlerInterceptor {
    @Override // true면 Controller 전달, False면 전달하지 않음
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("pre handle");

        var handlerMethod = (HandlerMethod)handler;

        var methodLevel = handlerMethod.getMethodAnnotation(OpenApi.class);
        if(methodLevel != null){
            log.info("method level");
            return true;
        }

        var classLevel = handlerMethod.getBeanType().getAnnotation(OpenApi.class);
        if(classLevel != null){
            log.info("class level");
            return true;
        }
        log.info("open api 아닙니다. : {}", request.getRequestURI());
        return false;
    }

    @Override // 화면에 view가 연결이 되었을때 호출이 된다.
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        log.info("post handle");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override // 완료되었을때 호출이 된다. 예외도 들어온다.
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        log.info("after completion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
