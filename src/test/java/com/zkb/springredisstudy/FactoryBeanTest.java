package com.zkb.springredisstudy;

import com.zkb.springredisstudy.bean.MyBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class FactoryBeanTest {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private MyBean myBean2;

    @Test
    public void test() {

        MyBean myBean = (MyBean) context.getBean("myBean");
        System.out.println(myBean.getMessage());

        MyBean myBean1 = (MyBean) context.getBean("&myBean");
        System.out.println(myBean1.getMessage());
        System.out.println(myBean.equals(myBean1));
        System.out.println(myBean2);
    }
}
