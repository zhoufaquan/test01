/*
package com.example.demo.controller.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class MyAdapter extends WebMvcConfigurationSupport {
    @Autowired
    private MyInterceptor myInterceptor;


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(myInterceptor).addPathPatterns("/bs/**")
               .excludePathPatterns("/bs/login","/bs/toLogin","/bs/Verification");
        super.addInterceptors(registry);
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //重写这个方法，映射静态资源文件
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }


}
*/
