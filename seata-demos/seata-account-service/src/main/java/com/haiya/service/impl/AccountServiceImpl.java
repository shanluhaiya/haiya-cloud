package com.haiya.service.impl;

import com.haiya.dao.AccountDao;
import com.haiya.entity.Account;
import com.haiya.service.AccountService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@DubboService(protocol = "dubbo")
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void debit(String userId, int money) throws Exception {
        System.out.println("accountService debit");
        Account info = accountDao.info(userId);
        if (info == null) {
            throw new Exception("用户不存在");
        }

        if ((info.getMoney() - money) < 0) {
            throw new Exception("用户余额不足");
        }

        accountDao.debit(userId, money);
    }
}
