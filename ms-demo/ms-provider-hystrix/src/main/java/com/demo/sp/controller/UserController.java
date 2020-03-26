package com.demo.sp.controller;

import com.demo.sp.bean.User;
import com.demo.sp.service.IUserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private IUserService userService;

    //@RequestMapping(value="/add", method= RequestMethod.POST)
    //public boolean addUser(@RequestBody User user)
    //{
    //    boolean flag = userService.addUser(user);
    //    return flag;
    //}

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    @HystrixCommand(fallbackMethod="hystrixGetUser") //一旦服务调用失败，就调用hystrixGetUser方法
    public User getUser(@PathVariable("id") String id)
    {
        User user = userService.getUser(id);
        if(user == null)
        {
            throw new RuntimeException("不存在id=" + id + "对应的用户信息");
        }
        return user;
    }

    @RequestMapping(value="/getUser/list", method=RequestMethod.GET)
    public List<User> getUsers()
    {
        List<User> users = userService.getUsers();
        return users;
    }

    public User hystrixGetUser(@PathVariable("id") String id)
    {
        User user = new User(id, "不存在该用户", "", 0);
        return user;
    }
}

/**
 * 1、服务熔断:当某个服务出现异常时，熔断该服务，快速返回指定的错误信息，当服务正常时，恢复熔断。
 * 2、服务降级:在一个分布式系统中，当访问高峰期或资源有限时，需要关掉某个服务，若有请求访问该服务，不能因为系统服务关掉了，就一直中断在该调用服务处，这时就需要请求返回指定的错误信息。
 */
