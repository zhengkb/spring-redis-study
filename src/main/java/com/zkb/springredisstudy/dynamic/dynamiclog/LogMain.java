package com.zkb.springredisstudy.dynamic.dynamiclog;

import com.zkb.springredisstudy.dynamic.cglib.basedynamic.Cat;
import com.zkb.springredisstudy.dynamic.jdk.exp3.Bird;

public class LogMain {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Bird object = LogFactory.getObject(Bird.class);

        Cat cat = LogFactory.getObject(Cat.class);


    }
}
