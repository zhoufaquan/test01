package com.example.demo.config;

import org.apache.shiro.authc.ConcurrentAccessException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.crypto.CryptoException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllException {
    @ExceptionHandler
    public String exceptiona(Exception ex) {
        if (ex instanceof UnauthenticatedException) {
            System.out.println("没有此权限！");
            return "error/403";
        } else if (ex instanceof UnauthorizedException) {
            System.out.println("你的级别还不够高,加油吧！少年。");
            return "error/403";
        } else if (ex instanceof ConcurrentAccessException) {
            System.out.println("我勒个去，页面被外星人挟持了!");
            return "error/403";
        }
        return null;
    }
}
