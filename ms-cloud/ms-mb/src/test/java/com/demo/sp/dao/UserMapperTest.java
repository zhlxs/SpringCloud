package com.demo.sp.dao;

import com.demo.sp.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserMapperTest
{
    public UserMapper userMapper;

    @Before
    public void setUp() throws Exception
    {
        // 指定配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 1. 映射文件的命名空间（namespace）必须是mapper接口的全路径
        // 2. 映射文件的statement的id必须和mapper接口的方法名保持一致
        // 3. Statement的resultType必须和mapper接口方法的返回类型一致
        // 4. statement的parameterType必须和mapper接口方法的参数类型一致（不一定）
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void login()
    {
        System.out.println(this.userMapper.login("hj", "123456"));
    }

    @Test
    public void queryUserByTableName()
    {
        List<UserInfo> userList = this.userMapper.queryUserByTableName("tb_user");
        for (UserInfo user : userList)
        {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserById()
    {
        System.out.println(this.userMapper.queryUserById(1l));
    }

    @Test
    public void queryUserAll()
    {
        List<UserInfo> userList = this.userMapper.queryUserAll();
        for (UserInfo user : userList)
        {
            System.out.println(user);
        }
    }

    @Test
    public void insertUser()
    {
        UserInfo user = new UserInfo();
        user.setAge(20);
        user.setBirthday(new Date());
        user.setName("大神");
        user.setPassword("123456");
        user.setSex(2);
        user.setUserName("bigGod222");
        this.userMapper.insertUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser()
    {
        UserInfo user = new UserInfo();
        user.setBirthday(new Date());
        user.setName("静静");
        user.setPassword("123456");
        user.setSex(0);
        user.setUserName("Jinjin");
        user.setId("1");
        this.userMapper.updateUser(user);
    }

    @Test
    public void deleteUserById()
    {
        this.userMapper.deleteUserById(1l);
    }
}
