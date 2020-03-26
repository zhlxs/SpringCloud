package com.demo.sp.api.impl;

import com.demo.sp.api.FeeService;
import com.demo.sp.enums.MemberEnum;
import org.springframework.stereotype.Component;

/**
 * 中级会员计费规则
 */
@Component
public class IntermediateMember implements FeeService
{
    @Override
    public Double compute(Double amount)
    {
        return 6.66;
    }

    @Override
    public Integer getType()
    {
        return MemberEnum.INTERMEDIATE_MEMBER.getCode();
    }
}
