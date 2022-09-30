package com.zkb.springredisstudy.controller;

import com.zkb.springredisstudy.redis.annotation.RedisLock;
import com.zkb.springredisstudy.service.TestAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestAnnotation testAnnotation;

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

    @GetMapping("/annotation")
    public void testAnnotation(Long uid, String value) {
        testAnnotation.execute(uid, value);
    }
}
