package com.zkb.springredisstudy.dynamic.jdk.exp4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyHandler implements InvocationHandler {

    private Object target;

    public Object getProxy(Object target) {
        this.target = target;
        Object instance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行之前");
        Object invoke = method.invoke(target, args);
        System.out.println("执行之后");
        return invoke;
    }
}
