package com.demo.sp.api.impl;

import com.demo.sp.api.FeeService;
import com.demo.sp.enums.MemberEnum;
import org.springframework.stereotype.Component;

/**
 * 高级会员计费规则
 */
@Component
public class SeniorMember implements FeeService
{

    @Override
    public Double compute(Double amount)
    {
        return 0.01;
    }

    @Override
    public Integer getType()
    {
        return MemberEnum.SENIOR_MEMBER.getCode();
    }
}
