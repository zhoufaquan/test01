package com.example.demo.controller.wp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wp/")
public class Index {


    @RequestMapping("Index")
    public String getIndex(){
        return "wp/Index";
    }
}
