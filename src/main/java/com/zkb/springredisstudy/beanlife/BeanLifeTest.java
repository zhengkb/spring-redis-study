package com.zkb.springredisstudy.beanlife;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        PersonBean personBean = (PersonBean) context.getBean("personBean");
        personBean.work();
        context.destroy();
    }

}
