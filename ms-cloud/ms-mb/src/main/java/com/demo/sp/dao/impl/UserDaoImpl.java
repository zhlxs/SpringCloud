package com.demo.sp.dao.impl;

import com.demo.sp.dao.UserDao;
import com.demo.sp.pojo.UserInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDaoImpl implements UserDao
{
    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession)
    {
        this.sqlSession = sqlSession;
    }

    @Override
    public UserInfo queryUserById(String id)
    {
        return this.sqlSession.selectOne("UserDao.queryUserById", id);
    }

    @Override
    public List<UserInfo> queryUserAll()
    {
        return this.sqlSession.selectList("UserDao.queryUserAll");
    }

    @Override
    public void insertUser(UserInfo user)
    {
        this.sqlSession.insert("UserDao.insertUser", user);
    }

    @Override
    public void updateUser(UserInfo user)
    {
        this.sqlSession.update("UserDao.updateUser", user);
    }

    @Override
    public void deleteUser(String id)
    {
        this.sqlSession.delete("UserDao.deleteUser", id);
    }
}
