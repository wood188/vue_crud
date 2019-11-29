package com.licong.response;

import com.licong.pojo.Goods;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Data
public class GoodsResponse {
    private List<Goods> list;
    private Integer page;
    private Long total;
}
