package com.wedrive.controller;

import com.wedrive.model.Payment;
import com.wedrive.model.Rental;
import com.wedrive.service.PaymentService;
import com.wedrive.service.RentalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private final RentalService rentalService;

    public PaymentController(PaymentService paymentService, RentalService rentalService) {
        this.paymentService = paymentService;
        this.rentalService = rentalService;
    }

    @PostMapping("/save/{rental_id}")
    public void savePayment(@RequestBody Payment payment, @PathVariable Long rental_id){
        Rental rental = rentalService.findRentalByID(rental_id);
        payment.setRental(rental);
        payment.setAmount();
        paymentService.savePayment(payment);
    }
}
