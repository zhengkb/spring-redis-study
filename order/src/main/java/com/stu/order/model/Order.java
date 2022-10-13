package com.stu.order.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Order {

    private String orderId;
    private Long userId;
    private Date createDate;
    private Date updateDate;
    private List<OrderDetail> orderDetailList;

    public Order() {
    }

    public Order(String orderId, Long userId, Date createDate, Date updateDate, List<OrderDetail> orderDetailList) {
        this.orderId = orderId;
        this.userId = userId;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.orderDetailList = orderDetailList;
    }
}
