package com.demo.sp.dao;

import com.demo.sp.pojo.UserInfo;

import java.util.List;

public interface UserDao
{
    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    public UserInfo queryUserById(String id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<UserInfo> queryUserAll();

    /**
     * 新增用户
     *
     * @param user
     */
    public void insertUser(UserInfo user);

    /**
     * 更新用户信息
     *
     * @param user
     */
    public void updateUser(UserInfo user);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    public void deleteUser(String id);
}
