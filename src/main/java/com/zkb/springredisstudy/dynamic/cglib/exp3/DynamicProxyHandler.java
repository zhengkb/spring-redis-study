package com.zkb.springredisstudy.dynamic.cglib.exp3;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicProxyHandler implements MethodInterceptor {

    private Object proxyObj;

    public DynamicProxyHandler(Object proxyObj) {
        this.proxyObj = proxyObj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("吃苹果之前先洗手");
        Object invoke = method.invoke(proxyObj, objects);
        System.out.println("永别了牢笼");
        return invoke;
    }

    public <T> T getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(this);
        enhancer.setSuperclass(proxyObj.getClass());
        return (T) enhancer.create();
    }


}
