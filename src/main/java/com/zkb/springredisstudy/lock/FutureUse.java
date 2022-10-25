package com.zkb.springredisstudy.lock;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureUse {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i = 0; i < 100; i++) {
            System.out.println("start");
            int input = 5;
            ExecutorService service = Executors.newFixedThreadPool(1);
            Future<Integer> future = service.submit(() -> {
                System.out.println(input);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return input * input;
            });
            Integer integer = future.get();
            System.out.println(integer);
            System.out.println("end");
        }
    }
}
