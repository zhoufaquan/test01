package com.example.demo.controller.bs;

import com.example.demo.aop.SystemControllerLog;
import com.example.demo.config.AllException;
import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import com.example.demo.util.VerificationUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.CryptoException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/* 后台管理主入口控制器 */

@Controller
@RequestMapping("bs")
public class BsMainController extends AllException {
    @Autowired
    private AdminService adminService;

    /* 后台登录界面跳转  */
    @RequestMapping("/login")
    public String goLogin(Model model, @RequestParam(defaultValue = "-1") String i) {
        if (i.equals("1")) {
            model.addAttribute("msg", "验证码错误");
        } else if (i.equals("2")) {
            model.addAttribute("msg", "密码错误");
        } else if (i.equals("3")) {
            model.addAttribute("msg", "账户已停用");
        } else if (i.equals("4")) {
            model.addAttribute("msg", "账户不存在");
        }
        return "bs/index";
    }


    /* 登录验证 */
    @RequestMapping(value = "/toLogin", method = RequestMethod.POST)
    @SystemControllerLog("用户登录")
    public String goToLogin(@RequestParam String account, @RequestParam String password, @RequestParam String code,
                            HttpServletRequest request, RedirectAttributes redirectAttributes) {
        String Vcode = (String) request.getSession().getAttribute("CODE");
        if (Vcode == null) {
            redirectAttributes.addAttribute("i", "1");
            return "redirect:login";
        }
        if (Vcode.equals(code)) {


            /* Boolean rememberMe = jsonP.getBoolean("agree");*/
            // 1.获取Subject
            Subject subject = SecurityUtils.getSubject();
            // 2.封装用户数据
            UsernamePasswordToken token = new UsernamePasswordToken(account, password, true);
            try {
                subject.login(token);
                Admin user = (Admin) SecurityUtils.getSubject().getPrincipal();
                request.getSession().setAttribute("ACCOUNT", account);
                request.getSession().setAttribute("ID", user.getaId());
                adminService.setAdminForLogin(user.getaId(), user.getaSt(), user.getaCount());
                return "redirect:mainpod";
            } catch (UnknownAccountException e) {
                System.out.println("用户不存在");
                redirectAttributes.addAttribute("i", "4");
                return "redirect:login";
            } catch (IncorrectCredentialsException e) {
                System.out.println("密码错误");
                redirectAttributes.addAttribute("i", "2");
                return "redirect:login";
            } catch (DisabledAccountException e) {
                /*停用*/
                redirectAttributes.addAttribute("i", "3");
                return "redirect:login";
            }
        } else {
            /*验证码*/
            redirectAttributes.addAttribute("i", "1");
            return "redirect:login";
        }

    }

    @RequestMapping("/Verification")
    public void getCode(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        response.setContentType("image/jpeg");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        session.removeAttribute("CODE");
        VerificationUtil vCode = new VerificationUtil(100, 30, 4, 60);
        session.setAttribute("CODE", vCode.getCode());
        try {
            vCode.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
