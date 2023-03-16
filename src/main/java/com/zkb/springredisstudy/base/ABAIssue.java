package com.zkb.springredisstudy.base;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABAIssue {

    private static AtomicInteger atomicInteger = new AtomicInteger(100);

    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 0);

    private static Thread TA = new Thread(() -> {
        System.err.println("未使用AtomicStampedReference线程组：[TA TB]>>>>>");

        boolean flag = atomicInteger.compareAndSet(100, 101);
        System.out.println("线程TA:100->101....flag：" + flag + ",atomicINNEWValue:" + atomicInteger.get());
        flag = atomicInteger.compareAndSet(101, 100);
        System.out.println("线程TA:101->100....flag：" + flag + ",atomicINNEWValue:" + atomicInteger.get());
    });

    private static Thread TB = new Thread(() -> {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean flag = atomicInteger.compareAndSet(100, 888);
        System.out.println("线程TB:100->888....flag：" + flag + ",atomicINNEWValue:" + atomicInteger.get());
    });

    private static Thread T1 = new Thread(() -> {
        System.err.println("使用AtomicStampedReference线程组：[T1 T2]>>>>");
        boolean flag = atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        System.out.println("线程T1：100 -> 101.... flag:" + flag + ".... asRefNewValue:" + atomicStampedReference.getReference() + ".... 当前Time：" + atomicStampedReference.getStamp());
        atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
        System.out.println("线程T1：101 -> 100.... flag:" + flag + ".... asRefNewValue:" + atomicStampedReference.getReference() + ".... 当前Time：" + atomicStampedReference.getStamp());
    });

    private static Thread T2 = new Thread(() -> {
        int time = atomicStampedReference.getStamp();
        System.out.println("线程休眠前Time值：" + time);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        boolean flag = atomicStampedReference.compareAndSet(100, 888, time, time + 1);
        System.out.println("线程T2:100->888... flag:" + flag + ".... asRefNewValue:" + atomicStampedReference.getReference() + ".... 当前Time:" + atomicStampedReference.getStamp());
    });

    public static void main(String[] args) throws InterruptedException {
        TA.start();
        TB.start();
        TA.join();
        TB.join();

        T1.start();
        T2.start();
    }


}
