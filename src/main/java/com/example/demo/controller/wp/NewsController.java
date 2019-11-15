package com.example.demo.controller.wp;

import com.example.demo.entity.News;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/wp")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/News/{nId}")

    public String getNews(@PathVariable Integer nId, Model model) {
    News news = newsService.getNews(nId);
    model.addAttribute("news",news);
        return "wp/NewsPage";
    }


}
