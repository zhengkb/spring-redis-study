package com.zkb.springredisstudy.event.springevent;

import org.springframework.context.ApplicationEvent;

public class OrderSuccessEvent extends ApplicationEvent {
    public OrderSuccessEvent(Object source) {
        super(source);
    }
}
