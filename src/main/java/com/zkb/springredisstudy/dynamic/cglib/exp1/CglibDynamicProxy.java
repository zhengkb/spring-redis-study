package com.zkb.springredisstudy.dynamic.cglib.exp1;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {

    private Object target;

    public CglibDynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理之前。。。。。。。。。。。。。。。。。。");
        Object obj = methodProxy.invoke(target, objects);
        System.out.println("代理之后。。。。。。。。。。。。。。。。。。");
        return obj;
    }

    public <T> T getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return (T) enhancer.create();
    }
}
