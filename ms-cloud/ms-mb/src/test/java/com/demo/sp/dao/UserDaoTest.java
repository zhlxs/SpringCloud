package com.demo.sp.dao;

//import org.jboss.arquillian.container.test.api.Deployment;
//import org.jboss.arquillian.junit.Arquillian;
//import org.jboss.shrinkwrap.api.ShrinkWrap;
//import org.jboss.shrinkwrap.api.asset.EmptyAsset;
//import org.jboss.shrinkwrap.api.spec.JavaArchive;
//import org.junit.runner.RunWith;
//
//import static org.junit.Assert.*;

import com.demo.sp.dao.impl.UserDaoImpl;
import com.demo.sp.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

//@RunWith(Arquillian.class)
public class UserDaoTest
{
    //    @Deployment
    //    public static JavaArchive createDeployment()
    //    {
    //        return ShrinkWrap.create(JavaArchive.class).addClass(UserDao.class)
    //                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    //    }

    public UserDao userDao;
    public SqlSession sqlSession;

    @org.junit.Before
    public void setUp() throws Exception
    {
        // mybatis-config.xml
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream(resource);
        // 构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 获取sqlSession
        sqlSession = sqlSessionFactory.openSession();
        this.userDao = new UserDaoImpl(sqlSession);
        // this.userDao = sqlSession.getMapper(UserDao.class);
        // 思考：能否只写接口，不写实现类。只编写接口和Mapper.xml即可？
        // 因为在dao（mapper）的实现类中对sqlsession的使用方式很类似。因此mybatis提供了接口的动态代理。
    }

    @org.junit.Test
    public void queryUserById()
    {
        System.out.println(this.userDao.queryUserById("1"));
    }

    @org.junit.Test
    public void queryUserAll()
    {
        List<UserInfo> userList = this.userDao.queryUserAll();
        for (UserInfo user : userList)
        {
            System.out.println(user);
        }
    }

    @org.junit.Test
    public void insertUser()
    {
        UserInfo user = new UserInfo();
        user.setAge(16);
        user.setBirthday(new Date("1990/09/02"));
        user.setName("大鹏");
        user.setPassword("123456");
        user.setSex(1);
        user.setUserName("jboss");
        this.userDao.insertUser(user);
        this.sqlSession.commit();
    }

    @org.junit.Test
    public void updateUser()
    {
        UserInfo user = new UserInfo();
        user.setBirthday(new Date());
        user.setName("静鹏");
        user.setPassword("654321");
        user.setSex(1);
        user.setUserName("evanjin");
        user.setId("1");
        this.userDao.updateUser(user);
        this.sqlSession.commit();
    }

    @org.junit.Test
    public void deleteUser()
    {
        this.userDao.deleteUser("4");
        this.sqlSession.commit();
    }
}
