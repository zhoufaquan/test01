package com.example.demo.controller.wp;

import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("wp/")
public class HomePage {
    /* 门户网站主页 */

    @Autowired
    private AdminService adminService;

    /* 进入主页 */
    @RequestMapping("HomePage")
    public String getHomePage(){
        return "wp/HomePage";
    }

}
