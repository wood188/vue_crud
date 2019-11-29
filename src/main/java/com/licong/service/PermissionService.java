package com.licong.service;

import com.licong.pojo.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> selectPer(String name);
}
