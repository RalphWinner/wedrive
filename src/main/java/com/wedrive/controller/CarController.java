package com.wedrive.controller;

import com.wedrive.model.Admin;
import com.wedrive.model.Car;
import com.wedrive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wedrive.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {
    private final CarService carService;
    private final AdminService adminService;

    @Autowired
    public CarController(CarService carService, AdminService adminService) {
        this.carService = carService;
        this.adminService = adminService;
    }

    @GetMapping
    public List<Car> findAllCar(){
        return carService.findAllCar();
    }

    @GetMapping("/{id}")
    public Optional<Car> findByID(@PathVariable("id") Long id) {
        return carService.findByID(id);
    }

    @PostMapping("/save/{admin_id}")
    public String saveCar(@RequestBody Car car, @PathVariable Long admin_id)
    {
        Admin admin = adminService.findAdminbyID(admin_id);
        car.setInsertBy(admin);
        return carService.saveCar(car);
    }

    @PutMapping
    public void updateCar(@RequestBody Car car) {
        carService.updateCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carService.deleteCar(id);
    }

}
