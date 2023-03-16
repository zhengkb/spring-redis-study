package com.zkb.springredisstudy.base;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 1; i <= 3; i++) {
            new Thread(() -> {
                try {
                    System.out.println("线程 " + Thread.currentThread().getName() + ".....阻塞等待");
                    countDownLatch.await();
                    System.out.println("线程+ " + Thread.currentThread().getName() + ".......开始执行任务");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "T " + i).start();
        }
        Thread.sleep(1000);
        countDownLatch.countDown();
    }
}
