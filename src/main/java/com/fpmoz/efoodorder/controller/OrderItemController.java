package com.fpmoz.efoodorder.controller;

import com.fpmoz.efoodorder.model.OrderItem;
import com.fpmoz.efoodorder.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderItemController {

    private OrderItemService orderItemService;

    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping(value = "/orderitem/get/all")
    public List<OrderItem> getOrder() {
        List<OrderItem> orderItems = new ArrayList<>();
        try {
            orderItems.addAll(orderItemService.getAll());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return orderItems;
    }
}
