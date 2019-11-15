package com.example.demo;

import com.example.demo.mapper.AdminMapper;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.AdminService;
import com.example.demo.service.AuthorityService;
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
    private AuthorityService authorityService;
    @Test
    public void getMenu(){
        authorityService.getMenu(1);
        authorityService.getMenu(1);
    }

    @Test
    public void contextLoads() {

    }
    @Test
    public void contextLoads2(){

    }
}
