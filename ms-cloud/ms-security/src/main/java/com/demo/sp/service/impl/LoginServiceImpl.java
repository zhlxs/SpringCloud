package com.demo.sp.service.impl;

import com.demo.sp.dao.UserMapper;
import com.demo.sp.model.LoginDetail;
import com.demo.sp.model.TokenDetail;
import com.demo.sp.service.LoginService;
import com.demo.sp.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version V1.0.0
 * @Description
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2017/10/3 2:12
 */
@Service
public class LoginServiceImpl implements LoginService
{

    private final UserMapper userMapper;
    private final TokenUtils tokenUtils;

    @Autowired
    public LoginServiceImpl(UserMapper userMapper, TokenUtils tokenUtils)
    {
        this.userMapper = userMapper;
        this.tokenUtils = tokenUtils;
    }

    @Override
    public LoginDetail getLoginDetail(String username)
    {
        return userMapper.getUserFromDatabase(username);
    }

    @Override
    public String generateToken(TokenDetail tokenDetail)
    {
        return tokenUtils.generateToken(tokenDetail);
    }
}
