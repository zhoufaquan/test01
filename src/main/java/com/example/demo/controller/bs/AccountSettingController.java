package com.example.demo.controller.bs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("bs")
public class AccountSettingController {


    @RequestMapping("AccountSetting")
    public String getAccountSetting(){
        return "bs/AccountSetting";
    }
}