package com.demo.sp.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class JdbcTest
{
    public static void main(String[] args) throws Exception
    {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try
        {
            //加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //获取连接
            String url = "jdbc:mysql://localhost:3306/ssm_demo?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user = "root";
            String password = "123456";
            conn = DriverManager.getConnection(url, user, password);
            // 获取statement，preparedStatement
            String sql = "select * from tb_user where id = ?";
            preparedStatement = conn.prepareStatement(sql);
            // 设置参数
            preparedStatement.setLong(1, 11l);
            // 执行查询
            resultSet = preparedStatement.executeQuery();
            // 处理结果集
            while (resultSet.next())
            {
                System.out.println("账号:" + resultSet.getString("user_name"));
                System.out.println("姓名:" + resultSet.getString("name"));
                System.out.println("年龄:" + resultSet.getInt("age"));
                System.out.println("生日:" + resultSet.getDate("birthday"));
            }
        } finally
        {
            // 关闭连接，释放资源
            if (resultSet != null)
            {
                resultSet.close();
            }
            if (preparedStatement != null)
            {
                preparedStatement.close();
            }
            if (conn != null)
            {
                conn.close();
            }
        }
    }
}
