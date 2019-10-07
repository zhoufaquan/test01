package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.Test;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.HashMap;

@Controller
public class MainController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("hello")
    public String Hello() {
        return "HelloWorld";
    }
    @RequestMapping("test")
    public String test(){
        System.out.println(adminService.selectByPrimaryKey(1));
        return "wp/HomePage";
    }
    /* requestbody测试 主要处理json*/
    @RequestMapping("body")
    public  String  body(@RequestBody Test test){
        System.out.println(test);
        return "wp/HomePage"; /* 注意路径写对*/
    }

    @RequestMapping("parm") /*localhost:8080/parm?id=1&tName="dasd"&tPwd="dsfsdf"  requestparm主要处理参数*/
    public  String  parm(@RequestParam Integer id,@RequestParam String tName,@RequestParam String tPwd){
        System.out.println(id+tName+tPwd);
        return "wp/HomePage"; /* 注意路径写对*/
    }

    @RequestMapping("pathvariable/{id}")
    public String pathvariable(@PathVariable Integer id){
        System.out.println(id);
        return "HelloWorld";
    }

    /*ajax 测试*/
    @RequestMapping("ajaxTest")
    @ResponseBody
    public String ajax(@RequestParam Integer id,@RequestParam String name){
        System.out.println(name);
        return "你成功了";
    }

    @RequestMapping(value = "ajaxTest2",method = RequestMethod.POST)
    @ResponseBody
    public String ajax2(@RequestBody Test test){
        System.out.println(test);
        return "你成功了";
    }

    @RequestMapping(value = "ajaxTest3",method = RequestMethod.POST)
    @ResponseBody
    public String ajax3(@RequestBody JSONObject jsonObject){
       Test test=JSONObject.parseObject(String.valueOf(jsonObject),Test.class);
        System.out.println(test);
        return "你成功了";
    }


}
