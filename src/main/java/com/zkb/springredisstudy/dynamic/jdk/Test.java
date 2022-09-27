package com.zkb.springredisstudy.dynamic.jdk;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Intermediary intermediary = new Intermediary("中介1号", new Tenant("李四"));
        RentInvocationHandler handler = new RentInvocationHandler(intermediary);
        Person person = (Person) Proxy.newProxyInstance(intermediary.getClass().getClassLoader(), intermediary.getClass().getInterfaces(), handler);
        System.gc();
        person.rentHouse();
    }
}
