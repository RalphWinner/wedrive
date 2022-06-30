package com.wedrive.service;

import com.wedrive.model.Car;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> findAllCar();
    Optional<Car> findByID(Long id);
    List<Car> findAllCarAvailable();
    Car saveCar(Car car);
    void updateCar(Car car);
    void deleteCar(Long id);
}
