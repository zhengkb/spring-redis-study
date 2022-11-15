package com.zkb.springredisstudy.lock;

import org.springframework.integration.util.CallerBlocksPolicy;

import java.util.concurrent.*;

public class PoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                25,
                300,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(125),
                Executors.defaultThreadFactory(),
                new CallerBlocksPolicy(100)
        );
        for (int i = 0; i < 11; i++) {
            Future<?> future = threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("okk");
            });
        }
    }
}
