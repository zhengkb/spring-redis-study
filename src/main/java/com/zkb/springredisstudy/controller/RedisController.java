package com.zkb.springredisstudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.locks.Lock;

@RestController
public class RedisController {

    @Autowired
    private RedisLockRegistry redisLockRegistry;


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
}
