package com.zkb.springredisstudy.dynamic.cglib.exp1;

public class Service {

    public final void finalMethod() {
        System.out.println("Service.finalMethod 被执行了");
    }

    public void publicMethod() {
        System.out.println("Service.publicMethod 被执行了");
    }
}
