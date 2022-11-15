package com.zkb.springredisstudy.dynamic.cglib.exp3;

public class CglibExp3Test {

    public static void main(String[] args) {
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(new Apple());
        Apple proxy = (Apple) dynamicProxyHandler.getProxy();
        proxy.eat();
    }
}
