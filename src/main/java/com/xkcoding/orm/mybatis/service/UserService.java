package com.xkcoding.orm.mybatis.service;

import com.xkcoding.orm.mybatis.entity.User;

import java.io.IOException;

/**
 * @author xiaorui
 * @date 2022-03-22 14:34
 */
public interface UserService {

    void saveUser(User user);

    void saveUser1(User user);

    void deleteUser(Long id,User user);
}
