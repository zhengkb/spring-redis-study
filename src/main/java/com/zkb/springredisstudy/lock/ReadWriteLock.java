package com.zkb.springredisstudy.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLock {

    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        new Thread(() -> {
            readLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " 得到锁");
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
                System.out.println(Thread.currentThread().getName() + " 释放锁");
            }
        }).start();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        new Thread(() -> {
            writeLock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "  得到锁");
                Thread.sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
                System.out.println(Thread.currentThread().getName() + " 释放锁");
            }
        }).start();
    }
}
