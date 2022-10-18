package com.stu.order.controller;

import com.stu.order.model.ItemAndAppName;
import com.stu.order.service.EurekaClientAccountFeign;
import com.stu.order.service.EurekaClientGoodsFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private EurekaClientAccountFeign eurekaClientAccountFeign;
    @Autowired
    private EurekaClientGoodsFeign eurekaClientGoodsFeign;

    @GetMapping("/goods")
    public ItemAndAppName getGoods(Long id) {
        return eurekaClientGoodsFeign.getGoods(id);
    }

    @GetMapping("/account")
    public String getAccount() {
        return eurekaClientAccountFeign.getAccount();
    }
}
