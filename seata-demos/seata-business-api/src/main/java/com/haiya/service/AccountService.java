package com.haiya.service;

public interface AccountService {
    /**
     * 从用户账户中借出
     */
    void debit(String userId, int money) throws Exception;
}
