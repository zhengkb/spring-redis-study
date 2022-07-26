package com.zkb.springredisstudy.redis;

import com.zkb.springredisstudy.redis.annotation.RedisLock;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Aspect
@Slf4j
@AllArgsConstructor
public class RedisAspect {

    @Autowired
    private RedissonClient redissonClient;


    @Around("@annotation(com.zkb.springredisstudy.redis.annotation.RedisLock)")
    public Object redisLockAop(ProceedingJoinPoint joinPoint) {
        RedisLock redisLock = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(RedisLock.class);
        RLock lock = redissonClient.getLock(redisLock.key());
        lock.lock(redisLock.time(), TimeUnit.MILLISECONDS);
        log.info("redis lock success");
        try {
            return joinPoint.proceed();
        } catch (Throwable e) {
            log.error("出现异常");
        } finally {
            lock.unlock();
            log.info("redis unlock success");
        }
        return null;
    }
}
