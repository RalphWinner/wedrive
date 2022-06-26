package com.wedrive.controller;

import com.wedrive.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wedrive.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> findAllCar(){
        return carService.findAllCar();
    }

    @GetMapping("/{id}")
    public Optional<Car> findByID(@PathVariable("id") Long id) {
        return carService.findByID(id);
    }

    @PostMapping
    public void saveCar(@RequestBody Car car) {
        carService.saveCar(car);
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
