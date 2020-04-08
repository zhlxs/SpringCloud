package com.demo.sp.service;

import com.demo.sp.model.LoginDetail;
import com.demo.sp.model.TokenDetail;

/**
 * @version V1.0.0
 * @Description
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2017/10/3 2:11
 */
public interface LoginService
{

    LoginDetail getLoginDetail(String username);

    String generateToken(TokenDetail tokenDetail);

}
