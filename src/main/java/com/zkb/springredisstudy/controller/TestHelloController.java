package com.zkb.springredisstudy.controller;

import com.zkb.springredisstudy.service.OrderService;
import io.lettuce.core.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHelloController {
    @Autowired
    private RedisLockRegistry redisLockRegistry;
    @Autowired
    private OrderService orderService;

    @GetMapping("/helloWorld")
    public String helloWorld() {
        orderService.order();
        return "hello world";
    }
}
