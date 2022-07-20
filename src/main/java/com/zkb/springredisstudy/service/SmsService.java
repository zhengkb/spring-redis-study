package com.zkb.springredisstudy.service;

import com.zkb.springredisstudy.event.springevent.OrderSuccessEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @EventListener(OrderSuccessEvent.class)
    public void sendSms() {
        System.out.println("发送短信");
    }
}
