package com.example.demo.controller.bs;

import com.example.demo.aop.SystemControllerLog;
import com.example.demo.config.AllException;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("bs")
public class BsMainPage extends AllException {

    @RequestMapping("/mainPage")
    public String goMainPage(){
        return "bs/mainPage";
    }


    @RequestMapping("/logout")
    @SystemControllerLog("用户退出")
    public String goLogout(){

        return "redirect:logoutDel";
    }
    @RequestMapping("/logoutDel")
    public String del(){
        SecurityUtils.getSubject().logout();
        return "redirect:login";
    }
    @RequestMapping("300")
    public String err(HttpServletResponse response){

        return "error/300";
    }
}
