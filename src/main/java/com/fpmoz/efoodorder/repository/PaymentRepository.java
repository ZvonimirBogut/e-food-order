package com.fpmoz.efoodorder.repository;

import com.fpmoz.efoodorder.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
