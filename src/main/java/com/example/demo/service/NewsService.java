package com.example.demo.service;

import com.example.demo.entity.News;
import com.example.demo.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsMapper newsMapper;
    public News getNews(int id){

        return newsMapper.selectByPrimaryKey(id);

    }
    public List<News> getTitleAndDate(){
        return newsMapper.selectTitleAndDate();
    }

}
