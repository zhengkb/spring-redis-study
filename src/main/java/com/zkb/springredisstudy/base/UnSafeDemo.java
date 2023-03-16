package com.zkb.springredisstudy.base;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnSafeDemo {

    public static void main(String[] args) throws Exception {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);

        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe);

        Demo demo = (Demo) unsafe.allocateInstance(Demo.class);
        Class<? extends Demo> demoClass = demo.getClass();
        Field str = demoClass.getDeclaredField("str");
        Field i = demoClass.getDeclaredField("i");
        Field staticStr = demoClass.getDeclaredField("staticStr");

        unsafe.putInt(demo, unsafe.objectFieldOffset(i), 1);
        unsafe.putObject(demo, unsafe.objectFieldOffset(str), "hello world");

        Object staticField = unsafe.staticFieldBase(staticStr);
        System.out.println("staticField:" + staticStr);

        long staticOffset = unsafe.staticFieldOffset(staticStr);
        System.out.println("设置前static字段值：" + unsafe.getObject(staticField, staticOffset));
        unsafe.putObject(staticField, staticOffset, "Hello java");
        System.out.println("设置后static字段值：" + unsafe.getObject(staticField, staticOffset));
        System.out.println("输出结果：" + demo.toString());
    }
}

class Demo {
    public Demo() {
        System.out.println("我是Demo类的构造函数，我被人调用创建对象实例啦....");
    }

    private String str;
    private int i;
    private static String staticStr = "Demo_Static";

    @Override
    public String toString() {
        return "Demo{" +
                "str = '" + str + '\'' +
                ", i = '" + i + '\'' +
                ", staticStr = " + staticStr + '\'' +
                '}';
    }
}
