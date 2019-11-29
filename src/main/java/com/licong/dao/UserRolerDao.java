package com.licong.dao;

import com.licong.pojo.UserRoler;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRolerDao {
    Integer userRolerAdd(UserRoler userRoler);
}
