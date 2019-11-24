package com.example.demo.controller.weixin;

import com.example.demo.entity.News;
import com.example.demo.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: zhouFaQuan
 * @Date: 2019/11/18 12:10
 */
@Controller
@RequestMapping("weixin")
public class NewsController2 {
    @Autowired
    private NewsService newsService;
//    @RequestMapping("getNews")
//    @ResponseBody
//    public List<News> getNews() {
//
//        List<News> news = newsService.getAll();
//       // System.out.println(news);
//        return news;
//    }


}
