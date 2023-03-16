package com.zkb.springredisstudy.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallAbleUse {

    private static CopyOnWriteArrayList<FutureTask> futureTasks = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyThreadCallable myThreadCallable = new MyThreadCallable();
        FutureTask<String> futureTask = new FutureTask<>(myThreadCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
        soutOkTask();
        futureTasks.add(futureTask);

        Thread.sleep(1000);
        FutureTask<String> futureTask2 = new FutureTask<>(myThreadCallable);
        Thread thread2 = new Thread(futureTask2);
        thread2.start();
        futureTasks.add(futureTask2);
        System.out.println("ok");
    }

    public static void soutOkTask() {
        new Thread(() -> {
            for (; ; ) {
                for (FutureTask futureTask : futureTasks) {
                    if (futureTask.isDone()) {
                        try {
                            System.out.println(futureTask.get());
                            futureTasks.remove(futureTask);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        } catch (ExecutionException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();
    }
}

class MyThreadCallable implements Callable<String> {


    @Override
    public String call() throws Exception {
        Thread.sleep(1000 * 5);
        return "hello world";
    }
}
