package com.example.demo.service;

import com.example.demo.entity.Logs;
import com.example.demo.mapper.LogsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsService {
    @Autowired
    private LogsMapper logsMapper;
    public int insert(Logs record){
        return logsMapper.insertSelective(record);
    }
    public int del(int logs_id){
        return logsMapper.deleteByPrimaryKey(logs_id);
    }
    public Logs sel(int logs_id ){
        return logsMapper.selectByPrimaryKey(logs_id);
    }
    public List<Logs> selectAll(){
        return  logsMapper.selectAll();
    }
}
