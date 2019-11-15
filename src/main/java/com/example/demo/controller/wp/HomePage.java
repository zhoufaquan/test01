package com.example.demo.controller.wp;

import com.example.demo.entity.Candidate;
import com.example.demo.entity.News;
import com.example.demo.service.AdminService;
import com.example.demo.service.CandidateService;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("wp/")
public class HomePage {
    /* 门户网站主页 */

    @Autowired
    private AdminService adminService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private CandidateService candidateService;
    /* 进入主页 */
    @RequestMapping("HomePage")
    public String getHomePage(Model model, HttpServletRequest request){
        String account= (String) request.getSession().getAttribute("account");
        String nickname=candidateService.getNickname(account);
        List<News> news = newsService.getTitleAndDate();
        model.addAttribute("news",news);
        model.addAttribute("nickname",nickname);
        return "wp/HomePage";
    }

}
