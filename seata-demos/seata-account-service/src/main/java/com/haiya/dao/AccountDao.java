package com.haiya.dao;

import com.haiya.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface AccountDao {
    Account info(@Param("userId") String userId);
    void debit(@Param("userId") String userId, @Param("money") int money);
}