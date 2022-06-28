package com.wedrive.controller;

import com.wedrive.model.Car;
import com.wedrive.model.Customer;
import com.wedrive.model.Rental;
import com.wedrive.service.CarService;
import com.wedrive.service.CustomerService;
import com.wedrive.service.RentalService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/rental/")
public class RentalController {
    private final RentalService rentalService;
    private final CarService carService;
    private final CustomerService customerService;

    public RentalController(RentalService rentalService, CarService carService, CustomerService customerService) {
        this.rentalService = rentalService;
        this.carService = carService;
        this.customerService = customerService;
    }

    @PostMapping(value = "save/{car_id}/{customer_id}")
    public String saveRental(@RequestBody Rental rental, @PathVariable Long car_id, @PathVariable Long customer_id)
    {
        Car car = carService.findByID(car_id).get();
        Customer customer = customerService.findByID(customer_id).get();
        rental.setCar(car);
        rental.setCustomer(customer);
        return rentalService.saveRental(rental);
    }

}
