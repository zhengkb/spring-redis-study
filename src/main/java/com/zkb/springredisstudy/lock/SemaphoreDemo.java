package com.zkb.springredisstudy.lock;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    private static Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                semaphore.acquire(1);
                System.out.println("A");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                semaphore.acquire(1);
                System.out.println("B");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                semaphore.acquire();
                System.out.println("C");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                semaphore.acquire(1);
                System.out.println("D");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
