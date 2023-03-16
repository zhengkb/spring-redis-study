package com.zkb.springredisstudy.base;

import java.util.concurrent.*;

public class ThreadPoolDemo {



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(1), new ThreadPoolExecutor.AbortPolicy());

        Future<?> first = threadPoolExecutor.submit(() -> {
            System.out.println("first task start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Future<?> second = threadPoolExecutor.submit(() -> {
            System.out.println("second task start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Future<?> third = threadPoolExecutor.submit(() -> {
            System.out.println("third task start");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("first:" + first.get());

        System.out.println("second:" + second.get());

        System.out.println("third:" + (third == null ? null : third.get()));

        threadPoolExecutor.shutdown();
    }
}
