package com.zkb.springredisstudy.lock;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 10, 3000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        executor.execute(() -> {

        });
    }
}
