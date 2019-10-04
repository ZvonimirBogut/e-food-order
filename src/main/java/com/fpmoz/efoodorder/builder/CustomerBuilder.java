package com.fpmoz.efoodorder.builder;

import com.fpmoz.efoodorder.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerBuilder {

    private Customer customer;

    public Customer getCustomer(){
        return this.customer;
    }

    public CustomerBuilder build(String firstName, String lastName, String mail, Integer phone){
        this.customer = new Customer();
        this.customer.setEmail(mail);
        this.customer.setFirstName(firstName);
        this.customer.setLastName(lastName);
        this.customer.setPhone(phone);
        return this;
    }
}
