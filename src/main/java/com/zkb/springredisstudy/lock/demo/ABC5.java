package com.zkb.springredisstudy.lock.demo;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ABC5 {
    private static AtomicInteger state = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(300000);


        Thread t1 = new Thread(() -> {
            printC(countDownLatch);
        });

        t1.start();

        Thread t2 = new Thread(() -> {
            printB(countDownLatch);
        });

        t2.start();

        Thread t3 = new Thread(() -> {
            printA(countDownLatch);
        });

        t3.start();

        countDownLatch.await();
        System.out.println(state);
    }

    public static void printA(CountDownLatch countDownLatch) {
        for (int i = 0; i < 100000; i++) {
            countDownLatch.countDown();
            while (state.get() % 3 != 0) {
                continue;
            }
            System.out.print("A");
            state.incrementAndGet();
        }
    }

    public static void printB(CountDownLatch countDownLatch) {
        for (int i = 0; i < 100000; i++) {
            countDownLatch.countDown();
            while (state.get() % 3 != 1) {
                continue;
            }
            System.out.print(" B");
            state.incrementAndGet();
        }
    }

    public static void printC(CountDownLatch countDownLatch) {
        for (int i = 0; i < 100000; i++) {
            countDownLatch.countDown();
            while (state.get() % 3 != 2) {
                continue;
            }
            System.out.println(" C");
            state.incrementAndGet();
        }
    }
}
