package com.haiya.service.impl;

import com.haiya.dao.OrderDao;
import com.haiya.entity.Order;
import com.haiya.service.AccountService;
import com.haiya.service.OrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService(protocol = "dubbo")
public class OrderServiceImpl implements OrderService {
    @DubboReference
    AccountService accountService;

    @Autowired
    OrderDao orderDao;

    @Override
    public Order create(String userId, String commodityCode, int price, int orderCount) throws Exception {
        System.out.println("orderService create");
        Integer totalPrice = price * orderCount;
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderNum(orderCount);
        order.setCommodityCode(commodityCode);
        order.setPrice(price);
        order.setTotalPrice(totalPrice);

        accountService.debit(userId, totalPrice);
        orderDao.create(order);
        return null;
    }
}
