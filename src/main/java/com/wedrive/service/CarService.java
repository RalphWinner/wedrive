package com.wedrive.service;

import com.wedrive.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAllCar();
    Optional<Car> findByID(Long id);
    Car findBycolor(String color);
    void saveCar(Car car);
    void updateCar(Car car);
    void deleteCar(Long id);
}
