package com.demo.sp.service.impl;

import com.demo.sp.dao.UserMapper;
import com.demo.sp.model.SecurityModelFactory;
import com.demo.sp.model.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @version V1.0.0
 * @Description Spring Security 用于将 数据库中的用户信息转换成 userDetail 对象的服务类的实现类
 * @Author liuyuequn weanyq@gmail.com
 * @Date 2017/8/2 16:43
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

    @Autowired
    private UserMapper userMapper;

    /**
     * 获取 userDetail
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {

        User user = this.userMapper.getUserFromDatabase(username);

        if (user == null)
        {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else
        {
            return SecurityModelFactory.create(user);
        }
    }
}
