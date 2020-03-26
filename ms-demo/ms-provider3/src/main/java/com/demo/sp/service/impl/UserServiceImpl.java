package com.demo.sp.service.impl;

import com.demo.sp.bean.User;
import com.demo.sp.dao.IUserDao;
import com.demo.sp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private IUserDao userDao;

    @Override
    public boolean addUser(User user)
    {
        boolean flag;
        flag = userDao.addUser(user);
        return flag;
    }

    @Override
    public User getUser(String id)
    {
        System.out.println("----------ms-provider3----------");
        User user = userDao.getUser(id);
        return user;
    }

    @Override
    public List<User> getUsers()
    {
        List<User> users = userDao.getUsers();
        return users;
    }
}
