package com.zkb.springredisstudy.dynamic.jdk.exp3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyHandler implements InvocationHandler {

    private Object target;

    public Object getProxy(Object target) {
        this.target = target;
        Object proxyInstance = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return proxyInstance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("附加执行");
        return method.invoke(target, args);
    }
}
