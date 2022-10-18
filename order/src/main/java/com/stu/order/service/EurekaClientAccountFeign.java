package com.stu.order.service;

import com.stu.order.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "account", configuration = FeignConfig.class)
public interface EurekaClientAccountFeign {

    @GetMapping(value = "/getAccount")
    String getAccount();
}
