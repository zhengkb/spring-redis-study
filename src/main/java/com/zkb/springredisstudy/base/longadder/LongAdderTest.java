package com.zkb.springredisstudy.base.longadder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderTest {
    public static void main(String[] args) throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                longAdder.add(1);
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(longAdder.longValue());

    }
}
