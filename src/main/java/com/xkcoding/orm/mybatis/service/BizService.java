package com.xkcoding.orm.mybatis.service;

import com.xkcoding.orm.mybatis.entity.User;

/**
 * @author xiaorui
 * @date 2022-03-23 18:20
 */
public interface BizService {
    void removeUser(Long id, User user);
}
