package com.example.demo.service;

import com.example.demo.entity.Exam;
import com.example.demo.mapper.ExamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    @Autowired
    private ExamMapper examMapper;
    public List<Exam> selectAll(){
        return examMapper.selectAll();
    }
}
