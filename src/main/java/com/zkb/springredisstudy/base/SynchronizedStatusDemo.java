package com.zkb.springredisstudy.base;

import org.openjdk.jol.info.ClassLayout;

public class SynchronizedStatusDemo {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();

        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        Thread.sleep(4000);

        Object obj1 = new Object();
        System.out.println(ClassLayout.parseInstance(obj1).toPrintable());

        synchronized (obj) {
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }

        new Thread(() -> {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        Thread.sleep(1);
        synchronized (obj) {
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }
}
