package com.example.demo.controller.bs;

import com.example.demo.aop.SystemControllerLog;
import com.example.demo.config.AllException;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Logs;
import com.example.demo.service.LogsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("bs")
public class LogsController extends AllException {
    @Autowired
    private LogsService logsService;

    @RequestMapping("logs")
    @RequiresPermissions("103")
    public String getLos(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum, HttpServletRequest request) {

        PageHelper.startPage(pageNum, 5);
        List<Logs> logsList = logsService.selectAll();

        PageInfo<Logs> pageInfo = new PageInfo<Logs>(logsList);

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("logs", logsList);
        return "bs/log";
    }
    @RequestMapping(value = "/logsdel")
    @RequiresPermissions("10302")
    @ResponseBody
    public int dels(int logs_id){

        return logsService.del(logs_id);
    }
    @RequestMapping(value = "/logsSel")
    @RequiresPermissions("10301")
    @ResponseBody
    public Logs sels(int logs_id){
        Logs logs=logsService.sel(logs_id);
        return logs;
    }
}
