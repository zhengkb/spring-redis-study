package com.zkb.springredisstudy.dynamic.cglib.exp2;

public class CGLIBDynamicExp2 {

    public static void main(String[] args) {
        ProxyHandler handler = new ProxyHandler(new Car());
        Car proxy = (Car) handler.getProxy();
        proxy.bibi();
    }
}
