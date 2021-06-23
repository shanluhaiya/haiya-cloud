package com.haiya.service.impl;

import com.haiya.dao.StorageDao;
import com.haiya.entity.Storage;
import com.haiya.service.StorageService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@DubboService(protocol = "dubbo")
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageDao storageDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void deduct(String commodityCode, int count) throws Exception {
        System.out.println("storageService deduct");
        Storage info = storageDao.info(commodityCode);
        if (info == null) {
            throw new Exception("商品不存在");
        }
        if (info.getCount() < count) {
            throw new Exception("商品库存不足");
        }
        storageDao.deduct(commodityCode, count);
    }
}
