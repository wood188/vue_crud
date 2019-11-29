package com.licong.service.impl;

import com.licong.dao.UserRolerDao;
import com.licong.pojo.UserRoler;
import com.licong.service.UserRolerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRolerServiceImpl implements UserRolerService {
    @Autowired
    private UserRolerDao userRolerDao;
    @Override
    public Integer userRolerAdd(UserRoler userRoler) {
        return userRolerDao.userRolerAdd(userRoler);
    }
}
