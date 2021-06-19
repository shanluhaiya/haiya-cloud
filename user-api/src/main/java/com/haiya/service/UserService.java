package com.haiya.service;

import com.haiya.po.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    User info(String id);
    int create(User user);
    int updateById(User user);
}
