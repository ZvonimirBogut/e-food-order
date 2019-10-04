package com.fpmoz.efoodorder.service.impl;

import com.fpmoz.efoodorder.model.Customer;
import com.fpmoz.efoodorder.repository.CustomerRepository;
import com.fpmoz.efoodorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Customer get(Integer id) {
        return this.customerRepository.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        this.customerRepository.deleteById(id);
    }
}
