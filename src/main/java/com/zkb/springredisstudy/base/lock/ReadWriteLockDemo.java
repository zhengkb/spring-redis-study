package com.zkb.springredisstudy.base.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final Lock readLock = readWriteLock.readLock();

    private final Lock writeLock = readWriteLock.writeLock();

    private Map<String, Integer> dataMap = new HashMap<>();

    public Integer getData(String key) {
        readLock.lock();
        try {
            return dataMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    public void addData(String key, Integer value) {
        writeLock.lock();

        try {
            dataMap.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(15, 25, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024));

        poolExecutor.submit(() -> {
            readWriteLockDemo.addData("abc", 1);
        });

        poolExecutor.submit(() -> {
            readWriteLockDemo.getData("abc");
        });

        poolExecutor.submit(() -> {
            readWriteLockDemo.getData("abc");
        });
    }
}
