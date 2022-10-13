package com.stu.order.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {

    private String orderId;

    private ItemAndAppName item = new ItemAndAppName();

    private OrderDetail() {
    }

    public OrderDetail(String orderId, ItemAndAppName item) {
        this.orderId = orderId;
        this.item = item;
    }
}
