package com.zkb.springredisstudy.base;

public class DeadLockDemo implements Runnable {

    private static Object o1 = new Object();

    private static Object o2 = new Object();

    public boolean flag = false;

    public DeadLockDemo(boolean flag) {
        this.flag = flag;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new DeadLockDemo(true), "T1");
        Thread t2 = new Thread(new DeadLockDemo(false), "T2");
        t1.start();
        t2.start();
    }

    @Override
    public void run() {
        if (flag) {
            synchronized (o1) {
                System.out.println("线程：" + Thread.currentThread().getName() + "持有o1.....");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程：" + Thread.currentThread().getName() + "等待o2.....");
                synchronized (o2) {
                    System.out.println("true");
                }
            }

        }

        if (!flag) {
            synchronized (o2) {
                System.out.println("线程：" + Thread.currentThread().getName() + "持有o2.....");
                try {
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("线程：" + Thread.currentThread().getName() + "等待o1.....");
                synchronized (o1) {
                    System.out.println(false);
                }
            }
        }
    }
}
