package com.demo.sp.dao;

import com.demo.sp.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper
{
    /**
     * 登录（直接使用注解指定传入参数名称）
     * @param userName
     * @param password
     * @return
     */
    public UserInfo login(@Param("userName") String userName, @Param("password") String password);

    /**
     * 根据表名查询用户信息（直接使用注解指定传入参数名称）
     * @param tableName
     * @return
     */
    public List<UserInfo> queryUserByTableName(@Param("tableName") String tableName);

    /**
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    public UserInfo queryUserById(Long id);

    /**
     * 查询所有用户信息
     * @return
     */
    public List<UserInfo> queryUserAll();

    /**
     * 新增用户信息
     * @param user
     */
    public void insertUser(UserInfo user);

    /**
     * 根据id更新用户信息
     * @param user
     */
    public void updateUser(UserInfo user);

    /**
     * 根据id删除用户信息
     * @param id
     */
    public void deleteUserById(Long id);
}
