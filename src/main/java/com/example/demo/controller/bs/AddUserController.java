package com.example.demo.controller.bs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bs")
public class AddUserController {
    @RequestMapping("addUser")
    public String addUser(){
        return "bs/addUser";
    }
}
