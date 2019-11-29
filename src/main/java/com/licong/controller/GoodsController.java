package com.licong.controller;

import com.licong.Utils.Upload;
import com.licong.pojo.Goods;
import com.licong.response.GoodsResponse;
import com.licong.service.GoodsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
public class GoodsController {
    @Value("${qiniu.url}")
    private String url;
    @Autowired
    private Upload up;
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/findall/{size}/{page}")
   // @RequiresPermissions(value = {"select"})
    private GoodsResponse findall(@PathVariable("size") Integer size, @PathVariable("page") Integer page) {
        System.out.println("size"+size+"page"+page);
        GoodsResponse goodsResponse=goodsService.findAll(size, page);
        System.err.println(goodsResponse);
        return goodsResponse;
    }

    @RequestMapping("/findone")
   // @RequiresPermissions(value = {"update"})
    private Goods findOne(@RequestBody Goods goods) {
        Integer id = goods.getGid();
        System.err.println("查询一个人");
        return goodsService.findOne(id);
    }

    @RequestMapping("/update")
    //@RequiresPermissions(value = {"update", "insert"})
    public Goods updateById(@RequestBody Goods goods) {
        try {
            /*if (!file.getOriginalFilename().trim().equals("")) {
                String upload = up.upload(file);
                goods.setGimg(url + upload);
                System.err.println("修改");
            }*/
            return goodsService.updateById(goods);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping("/delete")
    //@RequiresPermissions(value = {"delete"})
    public void deltetById(@RequestBody Goods goods) {
        Integer gid = goods.getGid();
        goodsService.deltetById(gid);
    }
}
