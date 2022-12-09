package com.zkb.springredisstudy.lock.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RetryABCBySyn {

    private static AtomicInteger state = new AtomicInteger(0);

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100));
        new Thread(() -> {
            printA();
        }).start();
        new Thread(() -> {
            printB();
        }).start();
        new Thread(() -> {
            printC();
        }).start();
    }

    public static void printA() {
        for (int i = 0; i < 10; ) {
            synchronized (state) {
                while (state.get() % 3 == 0) {
                    System.out.println("A");
                    state.addAndGet(1);
                    i++;
                }
            }
        }
    }

    public static void printB() {
        for (int i = 0; i < 10; ) {
            synchronized (state) {
                while (state.get() % 3 == 1) {
                    System.out.println("B");
                    state.addAndGet(1);
                    i++;
                }
            }
        }
    }

    public static void printC() {
        for (int i = 0; i < 10; ) {
            synchronized (state) {
                while (state.get() % 3 == 2) {
                    System.out.println("C");
                    state.addAndGet(1);
                    i++;
                }
            }
        }
    }
}
