package com.zkb.springredisstudy.dynamic.cglib.basedynamic;

public class LogObjectFactory {


    public static <T> T getObject(Class<T> t) {
        DynamicInterceptor dynamicInterceptor = new DynamicInterceptor();
        Object enhancer = dynamicInterceptor.getEnhancer(t);
        return (T) enhancer;
    }
}
