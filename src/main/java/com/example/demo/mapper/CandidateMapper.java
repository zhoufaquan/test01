package com.example.demo.mapper;

import com.example.demo.entity.Candidate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Candidate record);

    int insertSelective(Candidate record);

    Candidate selectByPrimaryKey(Integer cId);

    Candidate selectToLogin(Candidate candidate);

    int selectByPhone(String telephone);

    int selectByMail(String mail);

    String selectToNickname(String account);

    int updateByPrimaryKeySelective(Candidate record);

    int updateByPrimaryKey(Candidate record);

    Candidate WpLogin(@Param("account") String account, @Param("pwd") String pwd);
}