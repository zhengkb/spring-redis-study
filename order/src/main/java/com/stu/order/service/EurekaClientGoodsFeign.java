package com.stu.order.service;

import com.stu.order.config.FeignConfig;
import com.stu.order.model.ItemAndAppName;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "goods", configuration = FeignConfig.class)
public interface EurekaClientGoodsFeign {

    @GetMapping(value = "/item/query/{id}")
    ItemAndAppName getGoods(@PathVariable("id") Long id);
}
