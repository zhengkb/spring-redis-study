package com.zkb.springredisstudy.service;

import com.zkb.springredisstudy.event.annotation.Subscribe;
import com.zkb.springredisstudy.event.annotation.TestEvent;
import org.springframework.stereotype.Service;

@Service
public class TestHelloService {

    @Subscribe
    public void testEvent(TestEvent event) {
        System.out.println("test1:" + event.getInfo());
    }

}
