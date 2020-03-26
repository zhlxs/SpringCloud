package com.demo.sp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
public class DynamicProxy implements InvocationHandler
{

    private Object target;//目标对象

    public Object bind(Object target)
    {
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Exception
    {
        //执行目标对象的方法
        Object result = method.invoke(target,args);
        //实现扩展功能
        System.out.println("JDK动态代理:打印日志");
        return result;
    }
}
/**
 * 其实动态代理和静态代理的本质是一样的，最终程序运行时都需要生成一个代理对象实例。
 * 只不过静态代理是采用硬编码的方式在程序运行之前就创建好代理类，而动态代理是运行时动态生成的方式。
 * JDk帮我们实现了动态代理，使用的是newProxyInstance方法
 * public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 * 该方法中接收三个参数：
 * ClassLoader loader,:指定当前目标对象使用类加载器
 * Class<?>[] interfaces,:代理类需要实现的接口列表
 * InvocationHandler h:调用处理程序,将目标对象的方法分派到该调用处理程序。
 */
