package com.zkb.springredisstudy.lock.cyclelock;

import java.util.concurrent.atomic.AtomicReference;

public class SimpleSpinningLock {

    private AtomicReference<Thread> ref = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        while (!ref.compareAndSet(null, thread)) {
            System.out.println("加锁成功");
        }
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        if (ref.get() != thread) {
            throw new RuntimeException("解锁异常");
        }
        ref.set(null);
    }
}
