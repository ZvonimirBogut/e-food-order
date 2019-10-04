package com.fpmoz.efoodorder.service.impl;

import com.fpmoz.efoodorder.model.Order;
import com.fpmoz.efoodorder.repository.OrderRepository;
import com.fpmoz.efoodorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Order order) {
        this.orderRepository.saveAndFlush(order);
    }

    @Override
    public Order get(Integer id) {
        return this.orderRepository.findOrderById(id);
    }

    @Override
    public void delete(Integer id) {
        this.orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getAll() {
        return this.orderRepository.findAll();
    }
}
