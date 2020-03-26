package com.demo.sp;

import com.demo.sp.factory.ServiceFeeHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = StrategyTestApplication.class)
@RunWith(SpringRunner.class)
public class DemoTest
{
    @Autowired
    ServiceFeeHolder serviceFeeHolder;

    @Test
    public void test()
    {
        // 计算应缴纳费用
        System.out.println(serviceFeeHolder.getFee("juniorMember", 1.333));
        // 获取会员标志
        //System.out.println(serviceFeeHolder.getType("second"));
        // 会员描述错误，抛 IllegalArgumentException
        //System.out.println(serviceFeeHolder.getType("zero"));
    }
}
