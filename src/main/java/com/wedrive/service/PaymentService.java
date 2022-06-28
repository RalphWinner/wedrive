package com.wedrive.service;

import com.wedrive.model.Payment;
import org.springframework.stereotype.Service;

public interface PaymentService {
    String savePayment(Payment payment);
    Payment findPaymentByID(Long id);
}
