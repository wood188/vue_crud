package com.licong.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//自定义全局异常
@ControllerAdvice
public class ExceptionController {
    //捕捉异常
    @ExceptionHandler(value = AuthorizationException.class)
    public String exection(){
        return "unauth";
    }
}
