package com.zkb.springredisstudy.base.pool;

import io.netty.util.concurrent.DefaultThreadFactory;
import org.springframework.integration.util.CallerBlocksPolicy;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,
                5,
                100,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                new DefaultThreadFactory("zkbtest"),
                new CallerBlocksPolicy(1000)
        );

        for (int i = 0; i < 13; i++) {
            int num = i;
            poolExecutor.submit(() -> {
                try {
                    Thread.sleep(10000000);
                    System.out.println(num);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
