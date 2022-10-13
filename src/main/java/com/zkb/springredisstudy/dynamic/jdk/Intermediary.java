package com.zkb.springredisstudy.dynamic.jdk;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Intermediary implements Person {

    private String name;

    private Person tenant;

    @Override
    public void rentHouse() {
        System.out.println("agent：" + name + "确定预算，看房");
        tenant.rentHouse();
        System.out.println("agent：" + name + "看完房");
    }
}