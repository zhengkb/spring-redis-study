package com.zkb.springredisstudy.beanlife;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class PersonBean implements InitializingBean, BeanFactoryAware, BeanNameAware, DisposableBean {

    private Integer no;

    private String name;

    public PersonBean() {
        System.out.println("构造方法实例化");
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        System.out.println("设置person的编号");
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("设置Person的名字");
        this.name = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("设置bean工厂");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("设置bean的名称");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("销毁bean实例");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("设置bean属性信息");
    }

    public void myDestroy() {
        System.out.println("调用自己的销毁方法");
    }

    public void init() {
        System.out.println("调用自己的构建方法");
    }


    public void work() {
        System.out.println("执行程序");
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
