package com.demo.sp.controller;

import com.demo.sp.bean.User;
import com.demo.sp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    @Autowired
    private IUserService userService;

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public boolean addUser(@RequestBody User user)
    {
        boolean flag = userService.addUser(user);
        return flag;
    }

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    public User getUser(@PathVariable("id") String id)
    {
        User user = userService.getUser(id);
        return user;
    }

    @RequestMapping(value="/getUser/list", method=RequestMethod.GET)
    public List<User> getUsers()
    {
        List<User> users = userService.getUsers();
        return users;
    }
}
