package com.licong.service.impl;

import com.licong.dao.PermissionDao;
import com.licong.pojo.Permission;
import com.licong.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> selectPer(String name) {
        return permissionDao.selectPer(name);
    }
}
