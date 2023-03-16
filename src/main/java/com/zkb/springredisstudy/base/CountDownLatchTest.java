package com.zkb.springredisstudy.base;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {
    private static CountDownLatch latch = new CountDownLatch(10);


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
                    Thread.sleep(new Random().nextInt(10) * 1000);
                    System.out.println(Thread.currentThread().getName() + "check complete");
                } catch (Exception e) {

                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        System.out.println("ok");
        executorService.shutdown();
    }
}
