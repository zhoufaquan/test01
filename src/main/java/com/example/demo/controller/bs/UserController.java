package com.example.demo.controller.bs;

import com.example.demo.config.AllException;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Logs;
import com.example.demo.entity.Role;
import com.example.demo.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("bs")
public class UserController extends AllException {
    @Autowired
    private AdminService adminService;

    @RequestMapping("user")
    @RequiresPermissions("101")
    public String getUser(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Admin> adminList = adminService.selectAll2();
        PageInfo<Admin> pageInfo = new PageInfo<Admin>(adminList);


        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("admin", adminList);
        return "bs/user";
    }

    @RequestMapping("changeState")
    @RequiresPermissions("10103")
    @ResponseBody
    public int changestate(int a_id, boolean a_state) {
        return adminService.updateByIdTostate(a_state, a_id);
    }

    @RequestMapping("admindel")
    @RequiresPermissions("10102")
    @ResponseBody
    public int del(int a_id) {
        return adminService.deleteByPrimaryKey(a_id);
    }
    @RequestMapping("student")
    @RequiresPermissions("101")
    public String getstudent(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 5);
        List<Admin> adminList = adminService.selectAll2();
        PageInfo<Admin> pageInfo = new PageInfo<Admin>(adminList);


        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("admin", adminList);
        return "bs/RegManagement";
    }

}
