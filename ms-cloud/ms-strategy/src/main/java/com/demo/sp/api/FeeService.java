package com.demo.sp.api;

public interface FeeService
{
    /**
     * 计费规则
     * @param amount 会员的交易金额
     * @return
     */
    Double compute(Double amount);

    /**
     * 获取会员级别
     * @return
     */
    Integer getType();
}
