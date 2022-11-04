package com.zkb.springredisstudy.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@Component
public class IdCreate {

    private static final long BEGIN_TIMESTAMP = 1659312000l;

    @Autowired
    private RedisTemplate redisTemplate;

    public Long getRedisIncrementId(String item){
        LocalDateTime now = LocalDateTime.now();
        long second = now.toEpochSecond(ZoneOffset.UTC);
        long l = second - BEGIN_TIMESTAMP;
        String format = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        Long increment = redisTemplate.opsForValue().increment("id:" + item + ":" + format);
        return l<<32|increment;
    }
}
