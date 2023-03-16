package com.zkb.springredisstudy.base;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinDemo {
}

class CountTask extends RecursiveTask<Integer> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 12);
        ForkJoinTask<Integer> future = forkJoinPool.submit(countTask);
        System.out.println("最终计算结果：" + future.get());
    }

    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            System.out.println("执行计算任务，计算" + start + "加到" + end + "的和  执行此任务的线程：" + Thread.currentThread().getName());
        } else {
            System.out.println("任务过大，进行拆分" + start + "加到" + end + "的和  执行此任务的线程：" + Thread.currentThread().getName());
            int middle = (end + start) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            leftTask.fork();
            rightTask.fork();
            Integer leftResult = leftTask.join();
            Integer rightResult = rightTask.join();
            sum = rightResult + leftResult;
        }
        return sum;
    }
}
