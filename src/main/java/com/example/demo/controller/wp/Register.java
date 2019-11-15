package com.example.demo.controller.wp;

import com.example.demo.entity.Candidate;
import com.example.demo.service.CandidateService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("wp/")
public class Register {
    @Autowired
    private CandidateService candidateService;
    @RequestMapping("/Register")
    public String getRegister(){
        return "wp/Register";
    }

    @RequestMapping(value = "/toRegister",method = RequestMethod.POST)
    public String doRegister(Candidate candidate, Model model, HttpSession session){
        /**/
        String str[]={"","中华人民共和国居民身份证","台湾居民往来大陆通行证","港澳居民来往内地通行证","军人证件","护照","香港身份证","澳门身份证"};
        int type= Integer.parseInt(candidate.getcType());
        candidate.setcType(str[type]);
        int ret=candidateService.doRegister(candidate);
        if(ret==0){
            /*注册成功 直接使用此账号登录*/
          //  Candidate candidate1=candidateService.WpLogin(candidate.getcTelephone(),candidate.getcPwd());
            session.setAttribute("account",candidate.getcTelephone());
            return "redirect:HomePage";
        }else if(ret==1){
            /*账号已存在 返回注册界面并提示*/
            model.addAttribute("msg","此手机号已注册，请更换其它手机号，或使用该手机号登录");
        }else if(ret==2){
            model.addAttribute("msg2","此邮箱已注册，请更换其他邮箱");
        }


       return "wp/Register";
    }
}
