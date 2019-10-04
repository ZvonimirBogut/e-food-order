package com.fpmoz.efoodorder.controller;

import com.fpmoz.efoodorder.model.Payment;
import com.fpmoz.efoodorder.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/payment/save", consumes = "application/json")
    public ResponseEntity savePayment(@RequestBody Payment payment) {

        try {
            paymentService.save(payment);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/payment/get/{id}")
    public Payment getPayment(@PathVariable Integer id) {
        Payment payment = new Payment();
        try {
            payment = paymentService.get(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return payment;
    }

    @DeleteMapping(value = "/payment/delete/{id}")
    public ResponseEntity deletePayment(@PathVariable Integer id) {
        try {
            paymentService.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
