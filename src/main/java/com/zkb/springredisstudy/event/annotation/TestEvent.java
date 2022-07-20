package com.zkb.springredisstudy.event.annotation;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestEvent implements BaseEvent {

    private String info;
}
