package com.fpmoz.efoodorder.service;

import com.fpmoz.efoodorder.model.Payment;

public interface PaymentService {

    void save(Payment payment);

    Payment get(Integer id);

    void delete(Integer id);

}
