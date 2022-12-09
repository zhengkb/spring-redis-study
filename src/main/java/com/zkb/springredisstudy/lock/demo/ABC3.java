package com.zkb.springredisstudy.lock.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class    ABC3 {

    private static final Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();
    private static int state = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            ABC3.printA();
        }).start();
        new Thread(() -> {
            ABC3.printB();
        }).start();
        new Thread(() -> {
            ABC3.printC();
        }).start();
    }

    public static void printA() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (state % 3 != 0)
                    A.await();
                System.out.println("A");
                state++;
                B.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void printB() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (state % 3 != 1)
                    B.await();
                System.out.println("B");
                state++;
                C.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void printC() {
        try {
            lock.lock();
            for (int i = 0; i < 10; i++) {
                while (state % 3 != 2)
                    C.await();
                System.out.println("C");
                state++;
                A.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
