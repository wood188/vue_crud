package com.licong.service;


import com.licong.pojo.User;


public interface UserService {
    User selectOne(User user);
    Integer userAdd(User user);
}
