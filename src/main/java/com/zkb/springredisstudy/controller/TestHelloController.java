package com.zkb.springredisstudy.controller;

import io.lettuce.core.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHelloController {
    @Autowired
    private RedisLockRegistry redisLockRegistry;

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "hello world";
    }
}
