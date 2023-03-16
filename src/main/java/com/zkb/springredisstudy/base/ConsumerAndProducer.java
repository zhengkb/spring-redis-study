package com.zkb.springredisstudy.base;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerAndProducer {

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            produce();
        }, "生产者");

        Thread consumer = new Thread(() -> {
            consume();
        }, "消费者");

        producer.start();
        consumer.start();
    }

    private static Stack<String> work = new Stack<>();

    private static final int workNum = 25;

    private static final Lock lock = new ReentrantLock();

    private static Condition producerCondition = lock.newCondition();
    private static Condition consumerCondition = lock.newCondition();


    public static void produce() {
        do {
            try {
                lock.lock();
                while (work.size() == workNum) {
                    System.out.println(Thread.currentThread().getName() + " 进入阻塞,剩余工作：" + work.size());
                    producerCondition.await();
                }
                work.push("ABXI");
                System.out.println("producer-剩余工作:" + work.size());
                consumerCondition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } while (true);
    }

    public static void consume() {
        do {
            try {
                lock.lock();
                while (work.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " 进入阻塞");
                    consumerCondition.await();
                }
                work.pop();
                System.out.println("consumer-剩余工作:" + work.size());
                producerCondition.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        } while (true);
    }
}
