package com.demo.sp.controller;

import com.demo.sp.bean.User;
import com.demo.sp.service.ConsumerService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserConsumerController
{
    //private static String REST_URL_PREFIX = "http://localhost:8001";
    /*直接根据微服务名调用，而不再是根据地址和端口了，运用了eureka的发现功能*/
    //private static String REST_URL_PREFIX = "http://ms-provider";
    //@Autowired
    //private RestTemplate restTemplate;
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value="/consumer/add")
    public boolean addUser(User user)
    {
        //Boolean flag = restTemplate.postForObject(REST_URL_PREFIX + "/add", user, Boolean.class);
        Boolean flag = consumerService.add(user);
        return flag;
    }

    @RequestMapping(value="/consumer/get/{id}")
    public User get(@PathVariable("id") int id)
    {
        //User user = restTemplate.getForObject(REST_URL_PREFIX + "/get" + "/id", User.class);
        User user = consumerService.get(id);
        return user;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @RequestMapping(value="/consumer/list")
    public List<User> getList()
    {
        //List list = restTemplate.getForObject(REST_URL_PREFIX + "/getUser/list", List.class);
        List list = consumerService.getAll();
        return list;
    }
}
