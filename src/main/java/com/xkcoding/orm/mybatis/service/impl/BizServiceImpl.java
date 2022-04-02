package com.xkcoding.orm.mybatis.service.impl;

import com.xkcoding.orm.mybatis.entity.User;
import com.xkcoding.orm.mybatis.mapper.UserMapper;
import com.xkcoding.orm.mybatis.service.BizService;
import com.xkcoding.orm.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

/**
 * @author xiaorui
 * @date 2022-03-23 18:21
 */
@Service
public class BizServiceImpl implements BizService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeUser(Long id, User user) {
        userService.saveUser(user);
        userMapper.deleteById(id);
        int i = 1 / 0;
    }

}
