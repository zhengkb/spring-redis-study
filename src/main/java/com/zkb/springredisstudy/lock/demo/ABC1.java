package com.zkb.springredisstudy.lock.demo;

import org.omg.CORBA.MARSHAL;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程顺序输出ABC
 */
public class ABC1 {


    private final static Lock lock = new ReentrantLock();

    private static int state = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            ABC1.printA();
        }).start();
        new Thread(() -> {
            ABC1.printB();
        }).start();
        new Thread(() -> {
            ABC1.printC();
        }).start();
    }

    public static void printA() {
        for (int i = 0; i < 10;) {
            try {
                lock.lock();
                while (state % 3 == 0) {
                    System.out.println("A");
                    state++;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void printB() {
        for (int i = 0; i < 10;) {
            try {
                lock.lock();
                while (state % 3 == 1) {
                    System.out.println("B");
                    state++;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void printC() {
        for (int i = 0; i < 10;) {
            try {
                lock.lock();
                while (state % 3 == 2) {
                    System.out.println("C");
                    state++;
                    i++;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
