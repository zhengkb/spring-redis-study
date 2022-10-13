package com.stu.goods.controller;

import com.stu.goods.model.Item;
import com.stu.goods.model.ItemAndAppName;
import com.stu.goods.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Value("${spring.profiles}")
    private String name;

    /**
     * 对外提供接口服务，查询商品信息
     */
    @GetMapping(value = "/query/{id}")
    public ItemAndAppName queryItemById(@PathVariable("id") Long id) {
        ItemAndAppName itemAndAppName = new ItemAndAppName();
        itemAndAppName.setAppName(name);
        itemAndAppName.setItem(itemService.queryItemById(id));
        return itemAndAppName;
    }
}
