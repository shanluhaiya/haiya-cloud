package com.haiya.dao;

import com.haiya.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * insert, delete我们可以通过定义一个int返回值，通过返回值是否为0判断操作是否成功
 * update 默认返回的不是受影响的行数，而是匹配的行数。
 * 如果想要返回影响的行数，需要在jdbcUrl后面添加: useAffectedRows=true, 这样就是返回受影响的行数
 */
@Mapper
public interface UserDao {
    List<User> queryList(Map<String, Object> map);
    int queryTotal(Map<String, Object> map);
    int create(User user);
    int updateById(User user);
    User detail(@Param("id") String id);
}