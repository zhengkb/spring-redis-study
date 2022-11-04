package com.zkb.springredisstudy.dynamic.cglib.exp1;

public class CglibExp1Test {

    public static void main(String[] args) {
        CglibDynamicProxy proxy = new CglibDynamicProxy(new Service());
        Service cglibProxy = (Service) proxy.getProxy();
        cglibProxy.publicMethod();
        cglibProxy.finalMethod();
    }
}
