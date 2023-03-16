package com.zkb.springredisstudy.base;

import java.util.concurrent.Semaphore;

public class SemaphoreABC {

    private static final Semaphore semaphoreA = new Semaphore(1);

    private static final Semaphore semaphoreB = new Semaphore(0);
    private static final Semaphore semaphoreC = new Semaphore(0);

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
        for (int i = 0; i < 10000; i++) {
            try {
                semaphoreA.acquire();
                System.out.print("A");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphoreB.release();
            }
        }
    }

    public static void printB() {
        for (int i = 0; i < 10000; i++) {
            try {
                semaphoreB.acquire();
                System.out.print(" B");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphoreC.release();
            }
        }
    }

    public static void printC() {
        for (int i = 0; i < 10000; i++) {
            try {
                semaphoreC.acquire();
                System.out.println(" C");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphoreA.release();
            }
        }
    }

}
