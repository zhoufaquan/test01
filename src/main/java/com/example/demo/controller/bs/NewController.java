package com.example.demo.controller.bs;


import com.example.demo.config.AllException;
import com.example.demo.config.ShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bs")
public class NewController extends AllException {
    @RequestMapping("news")
    @RequiresPermissions("102")
    public String getNews() {
        return "bs/news";
    }
}
