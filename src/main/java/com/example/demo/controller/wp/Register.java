package com.example.demo.controller.wp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wp/")
public class Register {
    @RequestMapping("/Register")
    public String getRegister(){
        return "wp/Register";
    }
}
