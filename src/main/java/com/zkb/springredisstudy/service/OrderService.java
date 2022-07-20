package com.zkb.springredisstudy.service;


import com.zkb.springredisstudy.event.springevent.OrderSuccessEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ApplicationContext applicationContext;

    public void order() {
        System.out.println("下单成功");
        applicationContext.publishEvent(new OrderSuccessEvent(this));
        System.out.println("main线程结束");
    }
}
