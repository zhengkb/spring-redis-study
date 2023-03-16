package com.zkb.springredisstudy.base;

public class InheritableThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        threadLocal.set("hello world");
        inheritableThreadLocal.set("清澈");
        new Thread(() -> {
            System.out.println("threadLocal value" + threadLocal.get());
            System.out.println("inheritableThreadLocal value" + inheritableThreadLocal.get());
        }).start();
    }
}
