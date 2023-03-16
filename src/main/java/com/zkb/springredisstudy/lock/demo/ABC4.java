package com.zkb.springredisstudy.lock.demo;

import java.util.concurrent.Semaphore;

public class ABC4 {

    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);


    public static void main(String[] args) {
        new Thread(() -> {
            ABC4.printA();
        }).start();
        new Thread(() -> {
            ABC4.printB();
        }).start();
        new Thread(() -> {
            ABC4.printC();
        }).start();
    }

    public static void printA() {
        try {
            for (int i = 0; i < 100000; i++) {
                A.acquire();
                System.out.print("A");
                B.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printB() {
        try {
            for (int i = 0; i < 100000; i++) {
                B.acquire();
                System.out.print(" B");
                C.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printC() {
        try {
            for (int i = 0; i < 100000; i++) {
                C.acquire();
                System.out.println(" C");
                A.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
