package com.licong.dao;

import com.licong.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultType;

@Mapper
public interface UserDao {
    @ResultType(value = User.class)
    User selectOne(User user);
    Integer userAdd(User user);
}
