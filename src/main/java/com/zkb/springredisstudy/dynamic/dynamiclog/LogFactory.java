package com.zkb.springredisstudy.dynamic.dynamiclog;

public class LogFactory {


    public static <T> T getObject(Class<T> t) throws InstantiationException, IllegalAccessException {
        T newInstance = t.newInstance();
        LogInterceptor logInterceptor = new LogInterceptor(newInstance);
        Object enhancer = logInterceptor.getEnhancer();
        return (T) enhancer;
    }
}
