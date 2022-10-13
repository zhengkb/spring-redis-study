package com.stu.order.service;

import com.stu.order.model.Item;
import com.stu.order.model.ItemAndAppName;
import com.stu.order.model.Order;
import com.stu.order.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    private ItemService itemService;

    /**
     * 根据订单id查询订单数据
     */
    public Order queryOrderById(String orderId) {
        Order order = MAP.get(orderId);
        if (null == order) {
            return null;
        }
        List<OrderDetail> orderDetails = order.getOrderDetailList();
        for (OrderDetail orderDetail : orderDetails) {
            ItemAndAppName item = this.itemService.queryItemById(orderDetail.getItem().getItem().getId());
            if (null == item) continue;
            orderDetail.setItem(item);
        }
        return order;
    }


    private static final Map<String, Order> MAP = new HashMap<>();

    static {
        Order order = new Order();
        order.setOrderId("9527order");
        order.setCreateDate(new Date());
        order.setUpdateDate(new Date());
        order.setUserId(9527L);
        List<OrderDetail> orderDetails = new ArrayList<>();
        ItemAndAppName item = new ItemAndAppName();
        item.setItem(new Item());
        item.getItem().setId(2L);
        orderDetails.add(new OrderDetail(order.getOrderId(), item));
        ItemAndAppName item2 = new ItemAndAppName();
        item2.setItem(new Item());
        item2.getItem().setId(3L);
        orderDetails.add(new OrderDetail(order.getOrderId(), item2));
        order.setOrderDetailList(orderDetails);
        MAP.put(order.getOrderId(), order);
    }
}
