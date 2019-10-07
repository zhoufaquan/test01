package com.example.demo.controller.bs;

import com.example.demo.aop.SystemControllerLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("bs")
public class BsMainPage {

    @RequestMapping("/mainPage")
    public String goMainPage(){
        return "bs/mainPage";
    }

    @RequestMapping("/logout")
    @SystemControllerLog("用户退出")
    public String goLogout(HttpServletRequest request){
        request.getSession().removeAttribute("ACCOUNT");
        return "redirect:login";
    }
}
