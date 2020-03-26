package com.demo.sp.api.impl;

import com.demo.sp.api.FeeService;
import com.demo.sp.enums.MemberEnum;
import org.springframework.stereotype.Component;

/**
 * 初级会员计费规则
 */
@Component
public class JuniorMember implements FeeService
{

    @Override
    public Double compute(Double amount)
    {
        return 8.88;
    }

    @Override
    public Integer getType()
    {
        return MemberEnum.JUNIOR_MEMBER.getCode();
    }
}
