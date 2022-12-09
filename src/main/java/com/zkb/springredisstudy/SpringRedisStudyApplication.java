package com.zkb.springredisstudy;

import com.zkb.springredisstudy.bean.BeanLifeComponent;
import com.zkb.springredisstudy.bean.MyBean;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringRedisStudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringRedisStudyApplication.class, args);

        BeanLifeComponent bean = context.getBean(BeanLifeComponent.class);
        bean.use();
        MyBean myBean = (MyBean) context.getBean("&myBean");
        myBean.getMessage();
        context.close();
    }

}
