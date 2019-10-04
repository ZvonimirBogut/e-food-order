package com.fpmoz.efoodorder.service;

import com.fpmoz.efoodorder.model.Order;

import java.util.List;

public interface OrderService {

    void save(Order order);

    Order get(Integer id);

    void delete(Integer id);

    List<Order> getAll();
}
