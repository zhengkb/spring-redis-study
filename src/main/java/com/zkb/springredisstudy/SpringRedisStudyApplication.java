package com.zkb.springredisstudy;

import com.zkb.springredisstudy.bean.MyBean;
import com.zkb.springredisstudy.spring.EnableTeacherBean;
import com.zkb.springredisstudy.spring.Teacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableTeacherBean
public class SpringRedisStudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringRedisStudyApplication.class, args);

        context.getBean(Teacher.class).hello();

        MyBean bean = (MyBean) context.getBean("myBean");
        System.out.println(bean);

        MyBean bean1 = (MyBean) context.getBean("&myBean");
        System.out.println(bean1);

//        BeanLifeComponent bean = context.getBean(BeanLifeComponent.class);
//        bean.use();
//        MyBean myBean = (MyBean) context.getBean("&myBean");
//        myBean.getMessage();
//        context.close();
    }

}
