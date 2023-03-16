package com.zkb.springredisstudy.base;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    private static Object object = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            synchronized (object) {
                System.out.println("线程名字：" + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("线程被中断了");
                }
                System.out.println("继续执行");
            }
        });
        thread.start();
        LockSupport.unpark(thread);
        System.out.println("恢复线程调用" );
    }
}
