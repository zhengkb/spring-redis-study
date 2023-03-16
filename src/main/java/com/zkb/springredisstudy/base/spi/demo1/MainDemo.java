package com.zkb.springredisstudy.base.spi.demo1;

import java.util.Iterator;
import java.util.ServiceLoader;

public class MainDemo {
    public static void main(String[] args) {
        ServiceLoader<Aobing> serviceLoader = ServiceLoader.load(Aobing.class);
        Iterator<Aobing> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            Aobing aobing = iterator.next();
            aobing.say();
        }
    }
}
