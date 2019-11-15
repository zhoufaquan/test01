package com.example.demo;

import com.example.demo.service.AuthorityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplicationTests.class)
public class Test2 {
    @Autowired
    private AuthorityService authorityService;
    @Test
    public void getMenu(){
        authorityService.getMenu(1);
        authorityService.getMenu(1);
    }
}
