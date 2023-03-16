package com.zkb.springredisstudy.base;

public class GC {
    static void newObject() {
        for (int i = 0; i < 10000; i++) {
            new Object();
        }
    }

    public static void main(String[] args) {
        for (; ; ) {
            newObject();
        }
    }
}
