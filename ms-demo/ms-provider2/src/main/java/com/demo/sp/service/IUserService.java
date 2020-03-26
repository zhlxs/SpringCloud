package com.demo.sp.service;

import com.demo.sp.bean.User;

import java.util.List;

public interface IUserService
{
    public boolean addUser(User user);

    public User getUser(String id);

    public List<User> getUsers();
}
