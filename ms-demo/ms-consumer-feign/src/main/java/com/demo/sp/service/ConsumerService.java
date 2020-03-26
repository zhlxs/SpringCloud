package com.demo.sp.service;

import com.demo.sp.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*以后调用ms-provider微服务中的方法，只需要调用下面对应的接口既可以了*/
@FeignClient(value="ms-provider")
public interface ConsumerService
{
    /*调用接口中的get方法，即可以向ms-provider微服务发送/get/{id}请求*/
    @RequestMapping(value="/get/{id}", method= RequestMethod.GET)
    public User get(@PathVariable("id") int id);

    @RequestMapping(value="/add", method=RequestMethod.POST)
    public boolean add(User user);

    @RequestMapping(value="/getUser/list", method=RequestMethod.GET)
    public List<User> getAll();
}
/**
 * Feign是一个声明式WebService客户端。使用Feign能让编写Web Service客户端更加简单。Feign是对Ribbon的包装，Feign集成了Ribbon。
 * 前面在使用Ribbon+RestTemplate时，利用RestTemplate对http请求的封装处理，形成了一套模版化的调用方法。
 * 但是在实际开发中，由于对服务依赖的调用可能不止一处，往往一个接口会被多处调用，所以通常都会针对每个微服务自行封装一些客户端类来包装这些依赖服务的调用。
 * Feign在此基础上做了进一步封装，由他来帮助我们定义和实现依赖服务接口的定义。
 * 在Feign的实现下，我们只需创建一个接口并使用注解的方式来配置它，即可完成对服务提供方的接口绑定，简化了使用Spring cloud Ribbon时，自动封装服务调用客户端的开发量。
 * Feign既然是对Ribbon的包装，那么Feign也是用在客户端的，即消费端的。
 */
