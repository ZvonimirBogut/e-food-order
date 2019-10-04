package com.fpmoz.efoodorder.controller;

import com.fpmoz.efoodorder.builder.OrderBuilder;
import com.fpmoz.efoodorder.builder.PaymentBuilder;
import com.fpmoz.efoodorder.model.Order;
import com.fpmoz.efoodorder.service.OrderService;
import com.fpmoz.efoodorder.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    private OrderBuilder orderBuilder;

    private OrderService orderService;

    private PaymentService paymentService;

    private PaymentBuilder paymentBuilder;

    @Autowired
    public OrderController(OrderBuilder orderBuilder, OrderService orderService, PaymentService paymentService, PaymentBuilder paymentBuilder) {
        this.orderBuilder = orderBuilder;
        this.orderService = orderService;
        this.paymentService = paymentService;
        this.paymentBuilder = paymentBuilder;
    }

    @PostMapping(value = "/order/save", consumes = "application/json")
    public ResponseEntity saveOrder(@RequestBody Order order) {
        try {
            orderService.save(orderBuilder.build(order).getOrder());
            paymentService.save(paymentBuilder
                    .build(order.getCustomer(),
                            order.getQuantity(),
                            order.getOrderItem()
                                    .getPrice())
                    .getPayment());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>("You have payed: " + paymentBuilder.getPayment().getAmount(), HttpStatus.OK);
    }


    @GetMapping(value = "/order/get/{id}")
    public Order getOrder(@PathVariable Integer id) {
        Order order = new Order();
        try {
            order = orderService.get(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return order;
    }

    @GetMapping(value = "/order/get/all")
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try {
            orders = orderService.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return orders;
    }

    @DeleteMapping(value = "/order/delete/{id}")
    public ResponseEntity deleteOrder(@PathVariable Integer id) {
        try {
            orderService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
