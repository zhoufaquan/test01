package com.example.demo.controller.bs;

import com.example.demo.aop.SystemControllerLog;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 后台管理主入口控制器 */

@Controller
@RequestMapping("bs")
public class BsMainController {
    @Autowired
    private AdminService adminService;

    /* 后台登录界面跳转  */
    @RequestMapping("/login")
    public String goLogin(){
        return "bs/index";
    }


    /* 登录验证 */
    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    public String goToLogin(@RequestParam String account, @RequestParam String  password, HttpServletRequest request){
        Admin admin=adminService.selectToLogin(account,password);
        if(admin!=null){
            request.getSession().setAttribute("ACCOUNT",account);
            request.getSession().setAttribute("USERNAME",admin.getaName());
            adminService.setAdminForLogin(admin);


        }
        return "redirect:mainPage";
    }
}
