package com.haiya.controller;

import com.haiya.component.ServerConfig;
import com.haiya.po.User;
import com.haiya.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    ServerConfig serverConfig;

    @GetMapping("/info/{id}")
    public User info(@PathVariable("id") String id) {
        System.out.println(serverConfig.getUrl());
        return userService.info(id);
    }
}