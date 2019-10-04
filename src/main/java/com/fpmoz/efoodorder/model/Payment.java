package com.fpmoz.efoodorder.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "customer")
    @JsonBackReference
    private Customer customer;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "payment_date")
    private Date paymentDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {

        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
