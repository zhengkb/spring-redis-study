package com.zkb.springredisstudy.base;

import java.util.concurrent.*;

public class CompleteFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 24, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1024));


        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("执行程序A，返回50");
            return 50;
        }, poolExecutor);


        future.applyToEither(CompletableFuture.supplyAsync(() -> {
            System.out.println("程序B开始执行,返回75");
            return 75;
        }, poolExecutor), res -> {
            System.out.println("最终执行结果：" + res);
            return res;
        });

        poolExecutor.shutdown();
    }
}
