package com.fpmoz.efoodorder.service.impl;

import com.fpmoz.efoodorder.model.OrderItem;
import com.fpmoz.efoodorder.repository.OrderItemRepository;
import com.fpmoz.efoodorder.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository orderItemRepository;

    @Autowired
    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void save(OrderItem item) {
        this.orderItemRepository.save(item);
    }

    @Override
    public OrderItem getOne(Integer id) {
        return this.orderItemRepository.getOne(id);
    }

    @Override
    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        this.orderItemRepository.deleteById(id);

    }
}
