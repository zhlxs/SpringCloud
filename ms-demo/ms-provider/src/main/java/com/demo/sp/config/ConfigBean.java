package com.demo.sp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
@Configuration
public class ConfigBean
{

    @Bean(name = "multipartResolver")
    public MultipartResolver multipartResolver()
    {
        CommonsMultipartResolver com = new CommonsMultipartResolver();
        com.setDefaultEncoding("utf-8");
        return com;
    }
}
