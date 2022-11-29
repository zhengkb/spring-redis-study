package com.zkb.springredisstudy.dynamic.basedynamic;

import com.alibaba.fastjson2.JSONObject;
import jodd.util.CollectionUtil;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;

public class DynamicInterceptor implements MethodInterceptor {

    private Object target;

    public DynamicInterceptor(Object target) {
        this.target = target;
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
        Object invoke = method.invoke(target, objects);
        System.out.println("日志记录后");
        return invoke;
    }

    public Object getEnhancer() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }
}
