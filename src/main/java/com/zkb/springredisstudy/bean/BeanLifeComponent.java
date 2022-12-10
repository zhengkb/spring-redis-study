package com.zkb.springredisstudy.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BeanLifeComponent implements BeanNameAware {

    private MyBean myBean;

    @Autowired
    public BeanLifeComponent(MyBean myBean) {
        System.out.println("进行依赖注入");
        this.myBean = myBean;
    }

    public BeanLifeComponent() {
        System.out.println("设置属性");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("执行beanName的通知方法");
    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("执行初始化方法");
    }

    public void use() {
        System.out.println("使用bean");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("执行销毁方法");
    }
}
