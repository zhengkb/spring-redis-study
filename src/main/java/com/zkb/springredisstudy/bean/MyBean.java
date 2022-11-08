package com.zkb.springredisstudy.bean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements FactoryBean {

    private String message;

    public MyBean() {
        this.message = "通过构造方法实例化";
    }

    public MyBean(String message) {
        this.message = message;
    }

    @Override
    public Object getObject() throws Exception {
        return new MyBean("通过FactoryBean.getObject()构建实例");
    }

    @Override
    public Class<?> getObjectType() {
        return MyBean.class;
    }

    public String getMessage() {
        return message;
    }
}