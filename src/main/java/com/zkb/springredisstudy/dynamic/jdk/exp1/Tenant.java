package com.zkb.springredisstudy.dynamic.jdk.exp1;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Tenant implements Person {

    private String name;

    @Override
    public void rentHouse() {
        System.out.println("正在租房中");
    }
}
