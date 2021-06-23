package com.haiya.service;

import com.haiya.entity.Order;

/**
 * @author qiaoguoqiang
 */
public interface OrderService {
    Order create(String userId, String commodityCode, int price, int orderCount) throws Exception;
}
