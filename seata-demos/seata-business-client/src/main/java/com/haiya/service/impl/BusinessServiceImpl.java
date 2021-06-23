package com.haiya.service.impl;

import com.haiya.service.BusinessService;
import com.haiya.service.OrderService;
import com.haiya.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService {
    @DubboReference
    OrderService orderService;

    @DubboReference
    StorageService storageService;

    // @GlobalTransactional
    @Override
    public void purchase(String userId, String commodityCode, int price, int orderCount) {
        try {
            storageService.deduct(commodityCode, orderCount);
            orderService.create(userId, commodityCode, price, orderCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
