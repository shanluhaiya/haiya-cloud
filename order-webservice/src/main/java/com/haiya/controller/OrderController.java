package com.haiya.controller;

import com.haiya.entity.Order;
import com.haiya.po.User;
import com.haiya.service.UserService;
import com.haiya.utils.response.CommonRes;
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
    public CommonRes<Order> info(@PathVariable("id") String id) {
        Order order = new Order();
        order.setId("badr34123123213213");
        order.setUserId("bbe978ecd09b11eb8d8802f6c90fee7b");
        order.setPrice(12000L);
        User user = userService.info(id);
        order.setUser(user);

        return CommonRes.ok(order);
    }
}
