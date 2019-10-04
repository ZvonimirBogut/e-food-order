package com.fpmoz.efoodorder.builder;

import com.fpmoz.efoodorder.model.Customer;
import com.fpmoz.efoodorder.model.Payment;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class PaymentBuilder {

    private Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public PaymentBuilder build(Customer customer, Integer quantity, Double price){
        this.payment = new Payment();
        this.payment.setPaymentDate(new Date(System.currentTimeMillis()));
        this.payment.setAmount(quantity*price);
        this.payment.setCustomer(customer);
        return this;
    }
}
