package com.zkb.springredisstudy.circlereply;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class MySpring {

    //同singletonObjects，缓存beanName和实例
    private Map<String, Object> beanInstanceMap = new HashMap<>();
    //beanName 和BeanDefinition的缓存
    private Map<String, Class> beanDefinitionMap = new HashMap<>();
    //模仿BeanDefinition中的PropertyValue
    private Map<String, String> beanPropertyMap = new HashMap<>();

    private void init() {
        beanDefinitionMap.put("testA", TestA.class);
        beanDefinitionMap.put("testB", TestB.class);
        beanDefinitionMap.put("testC", TestC.class);

        beanPropertyMap.put("testA", "testB");
        beanPropertyMap.put("testB", "testC");
        beanPropertyMap.put("testC", "testA");
    }

    private Object getBean(String beanName) throws Exception {
        Object instance = beanInstanceMap.get(beanName);
        if (instance == null) {
            instance = beanDefinitionMap.get(beanName).newInstance();
            beanInstanceMap.put(beanName, instance);
            String property = beanPropertyMap.get(beanName);
            if (!StringUtils.isEmpty(property)) {
                Object propertyValue = getBean(property);
                setPropertyValue(instance, property, propertyValue);
            }
        }
        return instance;
    }

    private void setPropertyValue(Object instance, String property, Object propertyValue) throws Exception {
        Field field = instance.getClass().getDeclaredField(property);
        field.setAccessible(true);
        field.set(instance, propertyValue);
    }

    public static void main(String[] args) throws Exception {
        MySpring spring = new MySpring();
        spring.init();
        TestA testA = (TestA) spring.getBean("testA");
        //打印true
        System.out.println(testA.getTestB().getTestC().getTestA() == testA);
    }

}
