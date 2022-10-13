package com.stu.goods.model;

import lombok.Data;

@Data
public class Item {

    private Long id;
    private String title;
    private String pic;
    private Long price;

    public Item(){};

    public Item(Long id, String title, String pic, Long price) {
        this.id = id;
        this.title = title;
        this.pic = pic;
        this.price = price;
    }
}
