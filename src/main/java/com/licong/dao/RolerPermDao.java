package com.licong.dao;

import com.licong.pojo.RolerPerm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolerPermDao {
    Integer rolerPermAdd(RolerPerm rolerPerm);
}
