package com.demo.sp.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean
{
    /**
     * Ribbon负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }

    /**
     * 通过Ribbon的核心组件IRule定义查找消费端调用提供端微服务的策略
     * 如没有指定轮询策略，默认是消费端随机调用提供端微服的策略，下面指定轮询调用策略
     * @return
     */
    @Bean
    public IRule myRule()
    {
        return new RoundRobinRule(); 	//轮询策略
    }
}
