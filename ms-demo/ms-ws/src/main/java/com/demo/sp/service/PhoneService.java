package com.demo.sp.service;

import com.demo.sp.bean.Phone;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(serviceName = "PhoneManager",// 修改服务名
targetNamespace = "http://service.sp.demo.com")// 修改命名空间 ，默认包名，取反
//声明该业务类对外提供webservice服务,默认只是对public修饰的方法对外以webservice形式发布
public class PhoneService
{
    @WebMethod(operationName = "getMObileInfo")
    public Phone getPhoneInfo(@WebParam(name="osName")String osName)
    {
        Phone phone=new Phone();
        if(osName.endsWith("android"))
        {
            phone.setName("android");
            phone.setOwner("google");
            phone.setTotal(80);
        }else if(osName.endsWith("ios"))
        {
            phone.setName("ios");
            phone.setOwner("apple");
            phone.setTotal(15);
        }else
        {
            phone.setName("windows phone");
            phone.setOwner("microsoft");
            phone.setTotal(5);
        }
        return phone;
    }

    @WebMethod(exclude=true)//把该方法排除在外
    public void sayHello(String city)
    {
        System.out.println("你好:" + city);
    }
    private void sayLuck(String city)
    {
        System.out.println("好友:" + city);
    }
    void sayGoodBye(String city)
    {
        System.out.println("拜拜:" + city);
    }
    protected void saySayalala(String city)
    {
        System.out.println("再见:" + city);
    }

    public static void main(String[] args)
    {
        String address1="http://127.0.0.1:8889/ws/phoneService";
        //String address2="http://127.0.0.1:8888/ws/phoneManager";
        /**
         * 发布webservice服务
         * 1.address：服务的地址
         * 2：implementor 服务的实现对象
         */
        Endpoint.publish(address1, new PhoneService());
        //Endpoint.publish(address2, new PhoneService());
        System.out.println("WSDL地址:"+address1+"?WSDL");
    }
}
/**
 * 在类上添加@WebService注解,代表发布一个WebService服务；
 * 通过EndPoint(端点服务)发布一个webService。Endpoint也是jdk提供的一个专门用于发布服务的类，它的publish方法接收两个参数，一个是本地的服务地址，二是提供服务的类。它位于javax.xml.ws.*包中。
 * Endpoint.publish(String address, Object implementor) 静态方法在给定地址处针对指定的实现者对象创建并发布端点
 * 给类添加上@WebService注解后，类中所有的非静态方法都将会对外公布；
 * 如果希望某个方法不对外公开，可以在方法上添加@WebMethod(exclude=true)，阻止对外公开。
 * 如果一个类上，被添加了@WebService注解，则必须此类至少有一个可以公开的方法，否则将会启动失败。
 * protected、private、final、static方法不能对外公开。
 */