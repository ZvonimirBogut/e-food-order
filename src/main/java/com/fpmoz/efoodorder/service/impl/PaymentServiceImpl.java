package com.fpmoz.efoodorder.service.impl;

import com.fpmoz.efoodorder.model.Payment;
import com.fpmoz.efoodorder.repository.PaymentRepository;
import com.fpmoz.efoodorder.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void save(Payment payment) {
        this.paymentRepository.save(payment);
    }

    @Override
    public Payment get(Integer id) {
        return this.paymentRepository.getOne(id);
    }

    @Override
    public void delete(Integer id) {
        this.paymentRepository.deleteById(id);
    }
}
