package com.haiya.service.impl;

import com.haiya.po.User;
import com.haiya.service.UserInnerService;
import com.haiya.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService(protocol = "dubbo")
public class UserServiceImpl implements UserService {
    @Override
    public User info(String id) {
        User user = new User();
        user.setId(id);
        user.setUsername("海涯");
        user.setAge(20);
        user.setSalary(20000.00d);
        return user;
    }
}
