package com.demo.sp.enums;

public enum MemberEnum
{
    ORDINARY_MEMBER(0, "普通会员"), JUNIOR_MEMBER(1, "初级会员"), INTERMEDIATE_MEMBER(2, "中级会员"), SENIOR_MEMBER(3, "高级会员");

    int code;
    String desc;

    MemberEnum(int code, String desc)
    {
        this.code = code;
        this.desc = desc;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }
}
