package com.haiya.dao;

import com.haiya.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    int create(Order order);
}
