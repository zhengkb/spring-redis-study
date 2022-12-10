package com.zkb.springredisstudy.base.classloader;

public class ClassLoaderDemo extends ClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoaderDemo classLoaderDemo = new ClassLoaderDemo();
        Class<?> aClass = classLoaderDemo.loadClass("com.zkb.springredisstudy.base.longadder.LongAdderTest");
        System.out.println("自定义类加载器：" + classLoaderDemo);
        System.out.println("自定义类加载器父类加载器：" + classLoaderDemo.getParent());
        System.out.println("java程序默认类加载器：" + ClassLoader.getSystemClassLoader());
        System.out.println("系统类加载器父类加载器：" + ClassLoader.getSystemClassLoader().getParent());
        System.out.println("扩展类加载器父类加载器：" + ClassLoader.getSystemClassLoader().getParent().getParent());

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();

        ClassLoader systemClassLoader = getSystemClassLoader();


        System.out.println(contextClassLoader);

    }
}
