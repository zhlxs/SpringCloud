package com.demo.sp.proxy;

import com.demo.sp.bean.User;
import com.demo.sp.service.IUserService;

/**
 * 静态代理
 */
public class UserStaticProxy
{
    private IUserService userService;

    public UserStaticProxy(IUserService userService)
    {
        this.userService = userService;
    }

    public boolean add(User user)
    {
        System.out.println("静态代理模式:打印日志");
        return userService.addUser(user);
    }
}
/**
 * 缺点：
 * 1、接口增加方法，代理类需要同步维护。
 * 2、接口越多，需要创建的代理类就越多。比如以后我们有TeacherService,StudentService，就需要创建TeacherStaticProxy,StudentStaticProxy，这样就增加了代码量。
 */
