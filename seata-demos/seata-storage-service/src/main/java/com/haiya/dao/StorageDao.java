package com.haiya.dao;

import com.haiya.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StorageDao {
    Storage info(@Param("commodityCode") String commodityCode);
    int deduct(@Param("commodityCode") String commodityCode,@Param("count") int count);
}