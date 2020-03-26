package com.demo.sp.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib动态代理
 */
public class CGLibProxy implements MethodInterceptor
{

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(this.target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建并返回子类对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable
    {
        Object object = methodProxy.invokeSuper(o,objects);
        System.out.println("CGLib动态代理:打印日志");
        return object;
    }
}
/**
 * 如果只是一个普通的类，没有实现任何接口，该如何进行代理呢？这就引出了CGLib动态代理。CGLib动态代理也叫子类代理，
 * 它是在内存中构建一个子类对象从而实现对目标对象功能的扩展。
 * 要用cglib代理，需要导入相应的包，好在spring已经集成了它，引入spring即可。
 * 使用CGLib代理有两个注意点：
 * 1、目标对象不能被final关键字修饰，因为被final关键字修饰的对象是不可继承的。
 * 2、目标对象的方法如果是final/staic，那么该方法是不会被拦截（不能被增强），即不会执行目标对象额外的业务方法。
 */
