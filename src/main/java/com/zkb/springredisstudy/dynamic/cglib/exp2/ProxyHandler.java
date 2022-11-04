package com.zkb.springredisstudy.dynamic.cglib.exp2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyHandler implements MethodInterceptor {

    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始执行前");
        Object invoke = method.invoke(target, objects);
        System.out.println("开始执行后");
        return invoke;
    }

    public <T> T getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(target.getClass());
        return (T) enhancer.create();
    }
}
