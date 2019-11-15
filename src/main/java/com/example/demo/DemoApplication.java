package com.example.demo;

import com.example.demo.util.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;

@EnableCaching
@MapperScan("com.example.demo.mapper")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //   SpringApplication.run(DemoApplication.class, args);
      ApplicationContext applicationContext =
                SpringApplication.run(DemoApplication.class, args);
        SpringUtil.setApplicationContext(applicationContext);

    }

}
