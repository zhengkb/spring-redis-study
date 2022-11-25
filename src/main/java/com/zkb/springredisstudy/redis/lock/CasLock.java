package com.zkb.springredisstudy.redis.lock;

import org.springframework.util.CollectionUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CasLock {

    private static String ip = "39.103.78.212";
    private static int port = 6379;

    public static void main(String[] args) {
        String redisKey = "lock";
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        Jedis jedis = new Jedis(ip, port);
        jedis.set(redisKey, "0");
        jedis.close();

        for (int i = 0; i < 1000; i++) {
            executorService.execute(() -> {
                Jedis jedis1 = new Jedis(ip, port);
                try {
                    jedis1.watch(redisKey);
                    String value = jedis1.get(redisKey);
                    int valInteger = Integer.parseInt(value);
                    String userInfo = UUID.randomUUID().toString();
                    if (valInteger < 20) {
                        Transaction tx = jedis1.multi();
                        tx.incr(redisKey);
                        List<Object> list = tx.exec();
                        if (!CollectionUtils.isEmpty(list)) {
                            System.out.println("用户：" + userInfo + ",秒杀成功" + (valInteger + 1));
                        } else {
                            System.out.println("用户：" + userInfo + "秒杀失败");
                        }
                    } else {
                        System.out.println("排名不够");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    System.out.println("关闭");
                    jedis1.close();
                }
            });
        }
        executorService.shutdown();
    }
}
