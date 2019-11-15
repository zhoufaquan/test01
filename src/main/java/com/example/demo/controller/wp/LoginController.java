package com.example.demo.controller.wp;

import com.example.demo.entity.Candidate;
import com.example.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/wp")
public class LoginController {
    @Autowired
    private CandidateService candidateService;
    @RequestMapping("/login")
    public String Login(Model model,@RequestParam(defaultValue = "-1")String i){
        if(i.equals("1")){
            model.addAttribute("msg","验证码错误");
        }else if(i.equals("0")){
            model.addAttribute("msg","账户密码错误");
        }
        return "wp/login";
    }
    @RequestMapping("/tologin")
    public String WpLogin(HttpServletRequest request, String account, String password, String code, RedirectAttributes redirectAttributes){
        String v= (String) request.getSession().getAttribute("CODE");
        if(code.equals(v)){
            Candidate candidate=candidateService.WpLogin(account,password);
            if(candidate==null){
                redirectAttributes.addAttribute("i",0);
                return "redirect:login";
            }else{
                /*登录成功*/
                request.getSession().setAttribute("account",account);
                return "redirect:HomePage";
            }
        }else {
            redirectAttributes.addAttribute("i",1);
            return "redirect:login";
        }
    }

}
