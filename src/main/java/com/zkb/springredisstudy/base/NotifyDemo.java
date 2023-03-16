package com.zkb.springredisstudy.base;

import com.zkb.springredisstudy.base.tool.Factory;

public class NotifyDemo {

    public static void main(String[] args) {

        Factory factory = new Factory();

        Thread producer = new Thread(() -> {
            try {
                factory.put();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "生产者");

        Thread consumer = new Thread(() -> {
            try {
                factory.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "消费者");

        producer.start();
        consumer.start();
    }
}
