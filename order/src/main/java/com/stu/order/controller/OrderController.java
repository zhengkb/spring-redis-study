package com.stu.order.controller;

import com.stu.order.model.Order;
import com.stu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/query/{orderId}")
    public Order queryOrderById(@PathVariable("orderId") String orderId) {
        return orderService.queryOrderById(orderId);
    }
}