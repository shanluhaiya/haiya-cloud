package com.haiya.service;

public interface BusinessService {
    void purchase(String userId, String commodityCode, int price, int orderCount) throws Exception;
}
