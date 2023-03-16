package com.zkb.springredisstudy.dynamic.cglib.basedynamic;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicInterceptor implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();


    public Object getEnhancer(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (objects.length > 0) {
            for (Object object : objects) {
                String reflectionToString = ToStringBuilder.reflectionToString(object);
                System.out.println(reflectionToString);
            }
        }
        System.out.println("日志记录前");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("日志记录后");
        return invoke;
    }
}
