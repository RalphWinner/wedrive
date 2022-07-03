package com.wedrive.controller;

import com.wedrive.Utils.Utils;
import com.wedrive.model.Car;
import com.wedrive.model.Customer;
import com.wedrive.model.Payment;
import com.wedrive.model.Rental;
import com.wedrive.service.CarService;
import com.wedrive.service.CustomerService;
import com.wedrive.service.PaymentService;
import com.wedrive.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/rental/")
public class RentalController {
    private final RentalService rentalService;
    private final CarService carService;
    private final CustomerService customerService;
    private final PaymentService paymentService;

    public RentalController(RentalService rentalService, CarService carService, CustomerService customerService, PaymentService paymentService) {
        this.rentalService = rentalService;
        this.carService = carService;
        this.customerService = customerService;
        this.paymentService = paymentService;
    }

    @PostMapping(value = "save/{car_id}/{customer_id}")
    public String saveRental(@RequestBody Payment payment, @PathVariable Long car_id, @PathVariable Long customer_id)
    {
        Customer customer;
        Car car;
        try {
            customer = customerService.findByID(customer_id).get();
            car = carService.findByID(car_id).get();
        }catch (Exception e) {
            return "Not saved, car or customer are not exist";
        }
        if(rentalService.isCarRent(car)){
            return "Car already Rent, Cannot save.";
        } else if(!rentalService.checkDateisGood(payment.getRental().getStart_date(), payment.getRental().getEnd_date())){
            return "Date is not Correct";
        }
        car.setIs_rent(true);

        Rental rental = payment.getRental();
        rental.setCar(car);
        rental.setCustomer(customer);
        rental.setInsert_date(LocalDateTime.now());
        rental.setStatus("On Hold");

        Rental savedRental = rentalService.saveRental(rental);
        payment.setRental(savedRental);
        Utils utils = new Utils();
        float amount = utils.generateAmount(rental.getStart_date(), rental.getEnd_date(), rental.getCar().getPrice_per_day());
        payment.setAmount(amount);
        paymentService.savePayment(payment);

        SendEmail sendEmail = new SendEmail();
        sendEmail.SendingEMail("WeDrive MPP Project Rental Created"
                , "Your rental have been created successfully and you will receive an confirmation email when your rental is approved by an admin " +
                        " \n\n Your Car brand , model and year ==> " + rental.getCar().getBrand() + ", " + rental.getCar().getModel() + ", " + rental.getCar().getYear() +
                        " \n\n Starting date to Ending date ==> " + rental.getStart_date().toLocalDate() + " to " + rental.getEnd_date().toLocalDate() +
                        " \n\n your billing amount ==> " + payment.getAmount() +
                        " \n\n Payment Transaction Number ==> " + payment.getPayment_transaction_number()
                , savedRental.getCustomer().getUser().getEmail(), savedRental.getCustomer().getUser().getFirst_name() + " " + savedRental.getCustomer().getUser().getLast_name());

        return "Rental Saved";
    }

}
