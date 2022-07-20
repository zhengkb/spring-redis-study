package com.zkb.springredisstudy.service;


import com.zkb.springredisstudy.event.annotation.Subscribe;
import com.zkb.springredisstudy.event.annotation.TestEvent;

public class TestEventService {

    @Subscribe
    public void execute(TestEvent testEvent) {
        System.out.println("test2"+testEvent.getInfo());
    }
}
