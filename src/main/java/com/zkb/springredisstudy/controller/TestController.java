package com.zkb.springredisstudy.controller;

import com.zkb.springredisstudy.redis.annotation.RedisLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @RedisLock(key = "test")
    @GetMapping("/test")
    public String test() {
        return "hello world";
    }


    @RedisLock(key = "aop")
    @GetMapping("/aop")
    public String testAop(String value) {
        return value;
    }
}
