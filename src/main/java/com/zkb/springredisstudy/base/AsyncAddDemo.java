package com.zkb.springredisstudy.base;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncAddDemo {

    //    private static Unsafe unsafe = Unsafe.getUnsafe();
    private static int sum = 0;


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                sum++;
//                System.out.println("线程：" + Thread.currentThread().getName() + "，结果是：" + sum);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("值时：：：：：：" + sum);
    }
}
