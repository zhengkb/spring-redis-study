package com.zkb.springredisstudy.spring;

public class Teacher {

    private String[] name;

    public Teacher(String... name) {
        this.name = name;
    }

    public void hello() {
        System.out.println(name + "hello world");
    }
}
