package com.zkb.springredisstudy.spring;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class AutoConfiguredTeacherRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata metadata, BeanDefinitionRegistry registry) {
        System.out.println("执行bean的注册方法");
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();

        beanDefinition.setBeanClass(Teacher.class);
        beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, "张三");
        registry.registerBeanDefinition("teacher", beanDefinition);
        System.out.println("注册bean完成");
    }
}
