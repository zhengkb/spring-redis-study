package com.zkb.springredisstudy.lock.demo;

public class ABC6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("A");
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("B");
            }
        });

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                System.out.println("C");
            }
        });

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        t3.start();
        t3.join();
    }
}
