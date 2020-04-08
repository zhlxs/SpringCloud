package com.demo.sp.Interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * Mybatis拦截器
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class ExamplePlugin implements Interceptor
{
    @Override
    public Object intercept(Invocation invocation) throws Throwable
    {
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target)
    {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties)
    {
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        //业务逻辑......
    }
}
