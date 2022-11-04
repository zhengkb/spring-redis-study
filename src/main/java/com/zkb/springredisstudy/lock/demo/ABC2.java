package com.zkb.springredisstudy.lock.demo;

import java.util.concurrent.atomic.AtomicInteger;

public class ABC2 {

    private static AtomicInteger state = new AtomicInteger(0);

    public static void main(String[] args) {
        new Thread(() -> {
            ABC2.printA();
        }).start();
        new Thread(() -> {
            ABC2.printB();
        }).start();
        new Thread(() -> {
            ABC2.printC();
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
