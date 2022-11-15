package com.zkb.springredisstudy.reference;

import java.lang.ref.WeakReference;

public class WeakReferenceTest {

    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o);
        System.out.println("gc回收之前:" + weakReference.get());
        System.gc();
        System.out.println("gc回收之后：" + weakReference.get());
        o = null;
        System.out.println(weakReference.get());
        System.gc();
        System.out.println(weakReference.get());

    }
}
