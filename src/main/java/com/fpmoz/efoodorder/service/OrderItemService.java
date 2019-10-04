package com.fpmoz.efoodorder.service;

import com.fpmoz.efoodorder.model.OrderItem;

import java.util.List;

public interface OrderItemService {

    void save(OrderItem item);

    OrderItem getOne(Integer id);

    List<OrderItem> getAll();

    void delete(Integer id);
}
