package com.fpmoz.efoodorder.controller;


import com.fpmoz.efoodorder.model.Customer;
import com.fpmoz.efoodorder.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(value = "/customer/save", consumes = "application/json")
    public ResponseEntity saveCustomer(@RequestBody Customer customer) {

        try {
            customerService.save(customer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/customer/get/{id}")
    public Customer getCustomer(@PathVariable Integer id) {
        Customer customer = new Customer();
        try {
            customer = customerService.get(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return customer;
    }

    @DeleteMapping(value = "/customer/delete/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id) {
        try {
            customerService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
