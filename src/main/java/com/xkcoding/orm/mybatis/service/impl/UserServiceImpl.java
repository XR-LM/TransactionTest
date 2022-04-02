package com.xkcoding.orm.mybatis.service.impl;

import com.xkcoding.orm.mybatis.entity.User;
import com.xkcoding.orm.mybatis.mapper.UserMapper;
import com.xkcoding.orm.mybatis.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author xiaorui
 * @date 2022-03-22 14:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TransactionTemplate transactionTemplate;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public void saveUser1(User user) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @SneakyThrows
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
            userMapper.saveUser(user);
            throw new Exception("sd");
            }
        });
    }

    @Override
    @SneakyThrows
    public void deleteUser(Long id, User user) {
        this.saveUser(user);
        userMapper.deleteById(id);
        int i = 1 / 0;
    }
}
