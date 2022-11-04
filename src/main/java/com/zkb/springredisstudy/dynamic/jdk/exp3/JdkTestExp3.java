package com.zkb.springredisstudy.dynamic.jdk.exp3;

public class JdkTestExp3 {

    public static void main(String[] args) {
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler();
        IAnimal proxy = (IAnimal) dynamicProxyHandler.getProxy(new Bird());
        proxy.cry();
    }
}
