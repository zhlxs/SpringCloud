package com.demo.sp.factory;

import com.demo.sp.api.FeeService;
import com.demo.sp.entity.AliasEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class ServiceFeeHolder
{
    /**
     * 将 Spring 中所有实现 ServiceFee 的接口类注入到这个Map中//ordinaryMember,OrdinaryMember类似这样的键值对，由Spring管理
     */
    @Resource
    private Map<String, FeeService> serviceFeeMap;
    @Resource
    private AliasEntity aliasEntity;

    /**
     * 获取该会员应当缴纳的费用
     * @param desc 会员标志
     * @param money 交易金额
     * @return
     * @throws IllegalArgumentException 会员级别输入错误
     */
    public Double getFee(String desc, Double money)
    {
        return getBean(desc).compute(money);
    }

    /**
     * 获取会员标志（枚举中的数字）
     * @param desc 会员标志
     * @return
     * @throws IllegalArgumentException 会员级别输入错误
     */
    public Integer getType(String desc)
    {
        return getBean(desc).getType();
    }

    private FeeService getBean(String type)
    {
        // 根据配置中的别名获取该策略的实现类
        FeeService entStrategy = serviceFeeMap.get(aliasEntity.getEntity(type));
        //FeeService entStrategy = serviceFeeMap.get(type);
        if (entStrategy == null)
        {
            // 找不到对应的策略的实现类，抛出异常
            throw new IllegalArgumentException("error!");
        }
        return entStrategy;
    }
}
/**
 * 亮点：
 * 1.将 Spring中所有 ServiceFee.java 的实现类注入到Map中，不同策略通过其不同的key获取其实现类；
 * 2.找不到对应的策略的实现类，抛出IllegalArgumentException异常。
 */
