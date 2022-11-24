package com.zkb.springredisstudy.dynamic.basedynamic;

public class LogObjectFactory {


    public static  <T> T getObject(Class<T> t) throws InstantiationException, IllegalAccessException {
        T newInstance = t.newInstance();
        DynamicInterceptor dynamicInterceptor = new DynamicInterceptor(newInstance);
        Object enhancer = dynamicInterceptor.getEnhancer();
        return (T) enhancer;
    }
}
