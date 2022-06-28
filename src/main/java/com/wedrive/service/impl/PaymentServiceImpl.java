package com.wedrive.service.impl;

import com.wedrive.model.Payment;
import com.wedrive.model.Rental;
import com.wedrive.repository.PaymentRepository;
import com.wedrive.repository.RentalRepository;
import com.wedrive.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository, RentalRepository rentalRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public String savePayment(Payment payment) {
        Rental rental = payment.getRental();
        rental.setPayment(payment);
        paymentRepository.save(payment);
        return "Saved";
    }

    @Override
    public Payment findPaymentByID(Long id) {
        return paymentRepository.findById(id).get();
    }
}
