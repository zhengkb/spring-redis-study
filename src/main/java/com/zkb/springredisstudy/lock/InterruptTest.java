package com.zkb.springredisstudy.lock;

public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().isInterrupted());
                e.printStackTrace();
            }
        });
        t1.start();
        t1.interrupt();
        t1.join();
    }
}
