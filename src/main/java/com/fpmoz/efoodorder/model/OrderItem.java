package com.fpmoz.efoodorder.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "price")
    private Double price;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "customer",
            fetch = FetchType.LAZY)
    private List<Order> orders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
