package com.example.demo;

import com.example.demo.mapper.AdminMapper;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Test
    public void contextLoads() {
        System.out.println(testMapper.selectByPrimaryKey(1));
    }
    @Test
    public void contextLoads2(){
        System.out.println(adminMapper.selectByPrimaryKey(1));
    }
}
