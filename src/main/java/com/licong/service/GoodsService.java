package com.licong.service;

import com.licong.pojo.Goods;
import com.licong.response.GoodsResponse;


public interface GoodsService {
    GoodsResponse findAll(Integer size, Integer page);
    Goods findOne(Integer id);
    Goods updateById( Goods goods);
    void deltetById(Integer gid);
}
