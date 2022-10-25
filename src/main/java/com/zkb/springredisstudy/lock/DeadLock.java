package com.zkb.springredisstudy.lock;

public class DeadLock {

    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                sum(a, b);
            }).start();
            new Thread(() -> {
                sum(b, a);
            }).start();
        }
    }

    public static void sum(int a, int b) {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }
}
