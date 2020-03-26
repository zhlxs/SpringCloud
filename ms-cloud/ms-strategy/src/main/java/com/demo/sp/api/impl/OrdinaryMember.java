package com.demo.sp.api.impl;

import com.demo.sp.api.FeeService;
import com.demo.sp.enums.MemberEnum;
import org.springframework.stereotype.Component;

/**
 * 普通会员计费规则
 */
@Component
public class OrdinaryMember implements FeeService
{
    @Override
    public Double compute(Double amount)
    {
        return 9.99;
    }

    @Override
    public Integer getType()
    {
        return MemberEnum.ORDINARY_MEMBER.getCode();
    }
}
