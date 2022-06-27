package com.wedrive.controller;

import com.wedrive.model.Admin;
import com.wedrive.model.Car;
import com.wedrive.model.Rental;
import com.wedrive.service.AdminService;
import com.wedrive.service.CarService;
import com.wedrive.service.RentalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    private final AdminService adminService;
    private final RentalService rentalService;
    private final CarService carService;

    public AdminController(AdminService adminService, RentalService rentalService, CarService carService) {
        this.adminService = adminService;
        this.rentalService = rentalService;
        this.carService = carService;
    }

    @PostMapping("/save")
    String saveAdmin(@RequestBody Admin admin){
        return adminService.saveAdmin(admin);
    }

    @PostMapping("/approve_denied/{rental_id}/{approve_denied}")
    String approve_denied_rental(@PathVariable Long rental_id, @PathVariable int approve_denied)
    {
        Rental rental = rentalService.findRentalByID(rental_id);
        Car car = rental.getCar();

        rental.setStatus("Approved");
        car.setIs_rent(approve_denied == 1);

        carService.saveCar(car);
        rentalService.saveRental(rental);


        return "Rental Approved";
    }

    @GetMapping("/")
    List<Admin> findAllAdmin(){
        return adminService.findAllAdmin();
    }
}
