package com.example.demo.controller.bs;

import com.example.demo.aop.SystemControllerLog;
import com.example.demo.config.AllException;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Logs;
import com.example.demo.entity.Menu;
import com.example.demo.entity.Role;
import com.example.demo.service.AdminService;
import com.example.demo.service.AuthorityService;
import com.example.demo.service.LogsService;
import com.example.demo.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.bouncycastle.asn1.cms.PasswordRecipientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("bs")
public class BsMainPod extends AllException {
    @Autowired
    private LogsService logsService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private AuthorityService authorityService;
    @RequestMapping("/mainpod")

    public String mainpod(Model model, HttpSession session){
        String account= (String) session.getAttribute("ACCOUNT");
        Admin admin=adminService.getInfo(account);

        Role role=roleService.getInfo(admin.getaLimited());
        List<Menu> menus=authorityService.getMenu(admin.getaLimited());
      //  System.out.println(menus.get(1));
        model.addAttribute("name",admin.getaName());
        model.addAttribute("photo",admin.getaPhoto());
        model.addAttribute("role",role.getrRole());
        model.addAttribute("menu",menus);

        return "bs/MainPod";
    }

    @RequestMapping("test")
    @ResponseBody
    public   List<Menu> getInfo(){
        List<Menu> menus=authorityService.getMenu(1);
        return menus;
    }
}
