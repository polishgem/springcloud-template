package com.vedeng.template.service.user.impl;

import com.vedeng.template.domain.user.User;
import com.vedeng.template.domain.user.mapper.UserMapper;
import com.vedeng.template.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    @Cacheable(value = "users", key = "#id")
    public User queryUser(long id) {
        return userMapper.query(id);
    }
}
