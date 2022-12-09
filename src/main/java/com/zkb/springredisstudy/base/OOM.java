package com.zkb.springredisstudy.base;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.util.ArrayList;
import java.util.List;

public class OOM {

    public static class OomObject {
    }


    public static void RuntimeConstantPoolOOM() {
        List<String> list = new ArrayList<>();

        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    public static void MetaSpaceOOM(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OomObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor)
                    (o, method, objects, methodProxy)
                            -> methodProxy.invokeSuper(o, args));
            enhancer.create();
        }
    }

    public static void main(String[] args) {
        MetaSpaceOOM(args);
    }
}
