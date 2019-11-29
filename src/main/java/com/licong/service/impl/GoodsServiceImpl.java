package com.licong.service.impl;

import com.licong.pojo.Goods;
import com.licong.repository.GoodsRepository;
import com.licong.response.GoodsResponse;
import com.licong.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public GoodsResponse findAll(Integer size, Integer page) {
        if (page < 0) {
            page = 0;
        } else {
            page = page-1;
        }
        Pageable pageable = PageRequest.of(0, 4);
        Page<Goods> all = goodsRepository.findAll(pageable);
        List<Goods> content = all.getContent();
        GoodsResponse goodsResponse = new GoodsResponse();
        goodsResponse.setList(content);
        goodsResponse.setTotal(all.getTotalElements());
        goodsResponse.setPage(all.getTotalPages());
        return goodsResponse;
    }
    @Override
    public Goods findOne(Integer id) {
        Optional<Goods> byId = goodsRepository.findById(id);
        Goods goods = null;
        if (byId.isPresent()) {
            goods = byId.get();
        }
        return goods;
    }
    @Override
    public Goods updateById(Goods goods) {
        return  goodsRepository.saveAndFlush(goods);
    }

    @Override
    public void deltetById(Integer gid) {
        goodsRepository.deleteById(gid);
    }
}
