package com.fpmoz.efoodorder.repository;

import com.fpmoz.efoodorder.model.Order;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    Order findOrderById(Integer id);
}
