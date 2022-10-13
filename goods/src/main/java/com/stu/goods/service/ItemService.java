package com.stu.goods.service;

import com.stu.goods.model.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ItemService {

    public Item queryItemById(Long id) {
        return MAP.get(id);
    }

    private static final Map<Long, Item> MAP = new HashMap<>();

    static {
        MAP.put(1L, new Item(1L, "商品标题1", "http://图片1", 100L));
        MAP.put(2L, new Item(2L, "商品标题2", "http://图片2", 100L));
        MAP.put(3L, new Item(3L, "商品标题3", "http://图片3", 100L));
        MAP.put(4L, new Item(4L, "商品标题4", "http://图片4", 100L));
        MAP.put(5L, new Item(5L, "商品标题5", "http://图片5", 100L));
        MAP.put(6L, new Item(6L, "商品标题6", "http://图片6", 100L));
    }
}
