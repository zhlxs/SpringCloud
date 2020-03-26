package com.demo.sp.dao;

import com.demo.sp.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserDao
{
    public boolean addUser(User user);

    public User getUser(String id);

    public List<User> getUsers();
}
