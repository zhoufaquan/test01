package com.example.demo.controller.bs;

import com.example.demo.config.AllException;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Role;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;
import java.util.StringTokenizer;

@Controller
@RequestMapping("bs")
public class PsController extends AllException {
    @RequestMapping("/ps")
    public String getPages(Model model){
        Admin admin=(Admin) SecurityUtils.getSubject().getPrincipal();
        Set<Role> roles = admin.getRoles();
        Role role=(Role)roles.iterator().next();
        admin.setPermissions(null);
        System.out.println(role.getrRole());
        model.addAttribute(admin);

        model.addAttribute(role);
        return "bs/Person";
    }
}
