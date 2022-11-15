package com.zkb.springredisstudy.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 8);

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                threadLocal.set(threadLocal.get() + 1);
                System.out.println(threadLocal.get());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        System.out.println(threadLocal.get());
    }
}
