package com.zkb.springredisstudy.controller;

import com.zkb.springredisstudy.dynamic.cglib.basedynamic.Log;
import com.zkb.springredisstudy.redis.annotation.RedisLock;
import com.zkb.springredisstudy.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private KafkaService kafkaService;

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


    @GetMapping("/kafka")
    public void testKafka(Long uid, String value) {
        kafkaService.sendMessage();
    }

    @GetMapping("/topics")
    public Set<String> getTopics() throws ExecutionException, InterruptedException {
        return kafkaService.getAllTopics();
    }

    @PostMapping("/logTest")
    @Log
    public UserInfo getLogs(@RequestBody UserInfo userInfo) {
        userInfo.setName("hello world");
        return userInfo;
    }
}
