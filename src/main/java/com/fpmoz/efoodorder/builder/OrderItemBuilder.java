package com.fpmoz.efoodorder.builder;

import com.fpmoz.efoodorder.model.OrderItem;
import org.springframework.stereotype.Component;

@Component
public class OrderItemBuilder {

    private OrderItem orderItem;

    public OrderItem getOrderItem() {
        return this.orderItem;
    }

    public OrderItemBuilder build(String name, Double price){
        this.orderItem = new OrderItem();
        this.orderItem.setName(name);
        this.orderItem.setPrice(price);
        return this;
    }
}
