package com.stu.order.service;

import com.stu.order.model.Item;
import com.stu.order.model.ItemAndAppName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ItemService {

    @Autowired
    private RestTemplate restTemplate;

    public ItemAndAppName queryItemById(Long id) {
        return this.restTemplate.getForObject("http://goods/item/query/"+id,ItemAndAppName.class);
    }
}
