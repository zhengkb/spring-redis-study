package com.zkb.springredisstudy.base;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {

    private static ThreadLocal<LocalTest> testThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>());

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                System.out.println("创建对象");
                LocalTest localTest = new LocalTest();
                testThreadLocal.set(localTest);
                testThreadLocal.get();
                localTest = null;
            });
            Thread.sleep(1000);
        }
    }
}

class LocalTest {
    private byte[] bytes = new byte[100 * 1024 * 1024];
}
