package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Candidate;
import com.example.demo.mapper.CandidateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class CandidateService {
    @Autowired
    private CandidateMapper candidateMapper;

    public Map<String, String> toSign(Candidate candidate) {
        Map<String, String> map = new HashMap<>(3);
        int id=candidateMapper.selectByPhone(candidate.getcTelephone());
        if (id !=0) {
            /*账号存在 开始登录*/
            Candidate  candidate1= candidateMapper.selectToLogin(candidate);
            if(candidate1!=null){
                map.put("nickname",candidate1.getcNickname());
                map.put("photo",candidate1.getcImage());
                map.put("msg","1");
            }else {
                /*密码错误*/
                map.put("msg","2");
            }
        } else {
            /*注册*/
            String str=random();
            candidate.setcNickname(str);
            int flag = candidateMapper.insertSelective(candidate);
            if(flag==1){
                /*注册成功*/
                map.put("nickname",candidate.getcNickname());
                map.put("msg","3");
            }
        }
        map.put("telephone", candidate.getcTelephone());
        return map;
    }
    public Candidate WpLogin(String account,String pwd){

        return candidateMapper.WpLogin(account,pwd);
    }

    public String getNickname(String account){
        return candidateMapper.selectToNickname(account);
    }

    public int doRegister(Candidate candidate){

        int id=candidateMapper.selectByPhone(candidate.getcTelephone());
        int mark=0;
        if(candidate.getcMail()!=""){
            mark=candidateMapper.selectByMail(candidate.getcMail());
        }
        if (id !=0) {
            /*账号存在  返回1*/
            return 1;

        } else {
            /*注册*/
            /*mark==0 表示不用注册邮箱 邮箱为空 邮箱在数据库中不存在*/
            if(mark==0) {
                String str = random();
                candidate.setcNickname(str);
                int flag = candidateMapper.insertSelective(candidate);
                if (flag == 1) {
                    /*注册成功 返回0*/
                    return 0;
                }
            }else {
                /*邮箱在数据库中存在 不予注册 */
                return 2;
            }
        }


        return 0;
    }

    public String random() {
        String res = "";
        Random ran = new Random();
        String alp[] = {"a", "A", "B", "b", "c", "C", "D", "d", "E", "e", "f", "F", "g", "G", "H", "h", "I", "i", "j", "J", "k", "K", "L", "l", "M", "m"
                , "N", "n", "O", "o", "P", "p", "Q", "q", "R", "r", "S", "s", "T", "t", "U", "u", "V", "v", "W", "w", "X", "x", "Y", "y", "z", "Z"};
        String num[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        for (int i = 0; i < 3; i++) {
            res += alp[ran.nextInt(52)];
        }
        for (int i = 0; i < 9; i++) {
            res += num[ran.nextInt(10)];
        }
        return res;
    }
}
