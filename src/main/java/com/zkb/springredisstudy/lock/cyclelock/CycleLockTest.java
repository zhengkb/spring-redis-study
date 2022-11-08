package com.zkb.springredisstudy.lock.cyclelock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CycleLockTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        SimpleSpinningLock lock = new SimpleSpinningLock();
        AtomicInteger count = new AtomicInteger();
        for (int i = 0; i < 100; i++) {
            executorService.submit(() -> {
                lock.lock();
                count.incrementAndGet();
                lock.unlock();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(count.get());
    }
}
