package com.example.demo.mapper;

import com.example.demo.entity.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsMapper {
    int deleteByPrimaryKey(Integer nId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer nId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> selectTitleAndDate();
    int updateByPrimaryKeyWithBLOBs();
}