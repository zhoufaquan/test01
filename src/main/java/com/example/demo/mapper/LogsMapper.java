package com.example.demo.mapper;

import com.example.demo.entity.Logs;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(Logs record);

    int insertSelective(Logs record);

    Logs selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(Logs record);

    int updateByPrimaryKey(Logs record);
}