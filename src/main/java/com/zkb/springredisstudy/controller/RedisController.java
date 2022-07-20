package com.zkb.springredisstudy.controller;

import com.zkb.springredisstudy.event.annotation.EventBus;
import com.zkb.springredisstudy.event.annotation.TestEvent;
import com.zkb.springredisstudy.event.scan.SimpleClassScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.Lock;

@RestController
public class RedisController {

    @Autowired
    private RedisLockRegistry redisLockRegistry;
    @Autowired
    private SimpleClassScan simpleClassScan;


    @RequestMapping("/redisLock")
    public String redisLock(Integer id) {
        Lock lock = redisLockRegistry.obtain("USER_ID:" + id);
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " begin " + new Date());
                System.out.println(Thread.currentThread().getName() + " end " + new Date());
                lock.unlock();
            }).start();
        }
        return "ok";
    }


    @RequestMapping("/test")
    public String test() {
        TestEvent testEvent = new TestEvent();
        testEvent.setInfo("hello world");
        EventBus.postEvent(testEvent);
        return "ok";
    }
}