package com.demo.sp.mybatis;

import com.demo.sp.pojo.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest
{
    public static void main(String[] args) throws Exception
    {
        // 指定全局配置文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try
        {
            // 操作CRUD，第一个参数：指定statement，规则：命名空间+“.”+statementId
            // 第二个参数：指定传入sql的参数：这里是用户id
            UserInfo user = sqlSession.selectOne("MyMapper.selectUser", 11);
            System.out.println(user);
        } finally
        {
            sqlSession.close();
        }
    }
}
/**
 * 读取核心配置文件并返回InputStream流对象。
 * 根据InputStream流对象解析出Configuration对象，然后创建SqlSessionFactory工厂对象
 * 根据一系列属性从SqlSessionFactory工厂中创建SqlSession
 * 从SqlSession中调用Executor执行数据库操作&&生成具体SQL指令
 * 对执行结果进行二次封装
 * 提交与事务
 */
