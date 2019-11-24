package com.example.demo.mapper;

import com.example.demo.entity.Exam;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ExamMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Exam record);

    int insertSelective(Exam record);

    Exam selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Exam record);

    int updateByPrimaryKey(Exam record);

    List<Exam> selectAll();
}