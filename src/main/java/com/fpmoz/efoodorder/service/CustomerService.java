package com.fpmoz.efoodorder.service;

import com.fpmoz.efoodorder.model.Customer;

public interface CustomerService {

    void save(Customer customer);

    Customer get(Integer id);

    void delete(Integer id);
}
