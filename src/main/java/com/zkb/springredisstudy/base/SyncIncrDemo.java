package com.zkb.springredisstudy.base;

public class SyncIncrDemo implements Runnable {

    private static int num = 0;

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            incr();
        }
    }

    private void incr() {
        synchronized (SyncIncrDemo.class) {
            num++;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        SyncIncrDemo syncIncrDemo1 = new SyncIncrDemo();
        SyncIncrDemo syncIncrDemo2 = new SyncIncrDemo();

        Thread thread = new Thread(syncIncrDemo1);
        Thread thread1 = new Thread(syncIncrDemo2);

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(num);
    }
}
