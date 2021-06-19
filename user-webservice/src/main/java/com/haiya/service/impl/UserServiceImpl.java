package com.haiya.service.impl;

import com.haiya.dao.UserDao;
import com.haiya.po.User;
import com.haiya.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@DubboService(protocol = "dubbo")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> queryList(Map<String, Object> map) {
        return userDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userDao.queryTotal(map);
    }

    @Override
    public User info(String id) {
        User user = userDao.detail(id);
        return user;
    }

    @Override
    public int create(User user) {
        return userDao.create(user);
    }

    @Override
    public int updateById(User user) {
        return userDao.updateById(user);
    }
}
