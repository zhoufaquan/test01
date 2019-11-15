package com.example.demo.controller.bs;

import com.example.demo.config.AllException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bs")
public class UserController extends AllException {
    @RequestMapping("user")
    @RequiresPermissions("101")
    public String getUser(){
        return "bs/user";
    }
}
