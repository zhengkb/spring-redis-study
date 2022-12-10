package com.zkb.springredisstudy.lock.demo;

import java.util.concurrent.Semaphore;

public class SemaphoreABC {

    private static Semaphore semaphoreA = new Semaphore(1);

    private static Semaphore semaphoreB = new Semaphore(0);

    private static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
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
        try {
            for (int i = 0; i < 10; i++) {

                semaphoreA.acquire();
                System.out.println("A");
                semaphoreB.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printB() {
        try {
            for (int i = 0; i < 10; i++) {

                semaphoreB.acquire();
                System.out.println("B");
                semaphoreC.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printC() {
        try {
            for (int i = 0; i < 10; i++) {

                semaphoreC.acquire();
                System.out.println("C");
                semaphoreA.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
