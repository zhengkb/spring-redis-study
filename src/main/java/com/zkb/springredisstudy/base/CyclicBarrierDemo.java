package com.zkb.springredisstudy.base;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    private final static int threadCount = 15;

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;

            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(threadNum + " is ready " + cyclicBarrier.getNumberWaiting());
                    cyclicBarrier.await();
                    System.out.println(threadNum + " continue");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executorService.shutdown();
    }
}
