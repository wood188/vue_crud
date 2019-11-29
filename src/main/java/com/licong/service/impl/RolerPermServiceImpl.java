package com.licong.service.impl;

import com.licong.dao.RolerPermDao;
import com.licong.pojo.RolerPerm;
import com.licong.service.RolerPermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolerPermServiceImpl implements RolerPermService {
    @Autowired
    private RolerPermDao rolerPermDao;
    @Override
    public Integer rolerPermAdd(RolerPerm rolerPerm) {
        return rolerPermDao.rolerPermAdd(rolerPerm);
    }
}
