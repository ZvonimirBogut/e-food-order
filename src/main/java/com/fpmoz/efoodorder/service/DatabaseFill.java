package com.fpmoz.efoodorder.service;

import com.fpmoz.efoodorder.builder.CustomerBuilder;
import com.fpmoz.efoodorder.builder.OrderItemBuilder;
import com.fpmoz.efoodorder.repository.CustomerRepository;
import com.fpmoz.efoodorder.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DatabaseFill {

    private OrderItemBuilder orderItemBuilder;

    private OrderItemRepository orderItemRepository;

    private CustomerRepository  customerRepository;

    private CustomerBuilder customerBuilder;

    @Autowired
    public DatabaseFill(OrderItemBuilder orderItemBuilder, OrderItemRepository orderItemRepository, CustomerRepository customerRepository, CustomerBuilder customerBuilder) {
        this.orderItemBuilder = orderItemBuilder;
        this.orderItemRepository = orderItemRepository;
        this.customerRepository = customerRepository;
        this.customerBuilder = customerBuilder;
    }

    @PostConstruct
    public void createNewItems(){
        orderItemRepository.save(orderItemBuilder.build("Pizza", 5.7).getOrderItem());
        orderItemRepository.save(orderItemBuilder.build("Kebab", 4.0).getOrderItem());
        orderItemRepository.save(orderItemBuilder.build("Cevapi", 3.0).getOrderItem());
        orderItemRepository.save(orderItemBuilder.build("Sandwich", 2.5).getOrderItem());
        orderItemRepository.save(orderItemBuilder.build("Hamburger", 3.5).getOrderItem());
        orderItemRepository.save(orderItemBuilder.build("Cheeseburger", 3.7).getOrderItem());
    }

    @PostConstruct
    public void createCustomers(){
        customerRepository.save(customerBuilder.build("Kolinda", "Grabar-Kitarovic", "email", 63745829).getCustomer());
        customerRepository.save(customerBuilder.build("Miroslav", "Skoro", "skorin_email", 63111222).getCustomer());
        customerRepository.save(customerBuilder.build("Zoran", "Milanovic", "zokijev-email", 63666999).getCustomer());
    }
}
