package com.demo.sp.util;

/**
 * 断言工具
 */
public class Asserts
{
    public static void fail(String message)
    {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode)
    {
        throw new ApiException(errorCode);
    }
}
