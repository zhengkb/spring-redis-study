package com.zkb.springredisstudy.dynamic.basedynamic;

public class BaseDynamicTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Bird object = LogObjectFactory.getObject(Bird.class);
        object.birdCall();

        Cat cat = LogObjectFactory.getObject(Cat.class);
        Test a = new Test(1, "a");
        cat.call(a);
    }
}
