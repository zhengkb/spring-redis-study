package com.zkb.springredisstudy.dynamic.jdk;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@AllArgsConstructor
public class RentInvocationHandler implements InvocationHandler {

    private Object target;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before procuration");
        Object returnValue = method.invoke(target, args);
        System.out.println("after procuration");
        return returnValue;
    }
}
