package com.stu.order.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private Long id;
    private String title;
    private String pic;
    private Long price;

    public Item() {
    }

    ;

    public Item(Long id, String title, String pic, Long price) {
        this.id = id;
        this.title = title;
        this.pic = pic;
        this.price = price;
    }
}
