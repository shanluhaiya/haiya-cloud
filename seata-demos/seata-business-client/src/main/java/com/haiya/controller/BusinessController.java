package com.haiya.controller;

import com.haiya.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    BusinessService businessService;

    @PostMapping("/create")
    public void create() throws Exception {
        String userId = "1";
        String commodityCode = "mackbook pro 2021";
        Integer price = 399900;
        Integer count = 2;
        businessService.purchase(userId, commodityCode, price, count);
    }
}
