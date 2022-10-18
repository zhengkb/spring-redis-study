package com.zkb.springredisstudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    public void execute(String key, String value) {
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPush(key, value);
    }

    public List<String> getRedisValue(String key, int index) {
        ListOperations listOperations = redisTemplate.opsForList();
        List range = listOperations.range(key, 0, listOperations.size(key) - 1);
        return range;
    }
}
