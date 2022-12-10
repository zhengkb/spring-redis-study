package com.zkb.springredisstudy.dynamic.jdk.exp4;

public class JdkTestExp4 {
    public static void main(String[] args) {
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler();
        Tool proxy = (Tool) dynamicProxyHandler.getProxy(new Car());
        proxy.use();
    }
}
