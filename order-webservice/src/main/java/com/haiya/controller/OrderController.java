package com.haiya.controller;

import com.haiya.po.User;
import com.haiya.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@RequestMapping("/order")
public class OrderController {
    /**
     * @DubboReference(url = "dubbo://localhost:20881") 点对点直连
     */
    @DubboReference
    UserService userService;

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") String id) {
        User user = userService.info("11111");
        return "order id = " + id + " is belong to user {" + user.getUsername() + "," + user.getId() + "}";
    }
}
