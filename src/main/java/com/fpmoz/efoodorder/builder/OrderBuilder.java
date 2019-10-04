package com.fpmoz.efoodorder.builder;

import com.fpmoz.efoodorder.model.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class OrderBuilder {

    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderBuilder build(Order order){
        this.order = new Order();
        this.order.setCustomer(order.getCustomer());
        this.order.setOrderItem(order.getOrderItem());
        this.order.setQuantity(order.getQuantity());
        this.order.setOrderDate(new Date(System.currentTimeMillis()));
        return this;
    }
}
