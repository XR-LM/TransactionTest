package com.xkcoding.orm.mybatis;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.xkcoding.orm.mybatis.entity.User;
import com.xkcoding.orm.mybatis.service.BizService;
import com.xkcoding.orm.mybatis.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDemoOrmMybatisApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    BizService bizService;

    @Test
    public void saveUser() {
        String salt = IdUtil.fastSimpleUUID();
        User user = User.builder().name("testSave1").password(SecureUtil.md5("123456" + salt)).salt(salt).email("testSave3@xkcoding.com").phoneNumber("17300000003").status(1).lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
        userService.saveUser(user);
    }

    @Test
    public void saveUser1() {
        String salt = IdUtil.fastSimpleUUID();
        User user = User.builder().name("testSave44").password(SecureUtil.md5("1233456" + salt)).salt(salt).email("testSave345@xkcoding.com").phoneNumber("1730023000003").status(1).lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
        bizService.removeUser(6L,user);
    }

    @Test
    public void saveUser3() {
        String salt = IdUtil.fastSimpleUUID();
        User user = User.builder().name("testSave44").password(SecureUtil.md5("1233456" + salt)).salt(salt).email("testSave345@xkcoding.com").phoneNumber("1730023000003").status(1).lastLoginTime(new DateTime()).createTime(new DateTime()).lastUpdateTime(new DateTime()).build();
        userService.deleteUser(2L,user);
    }
}

