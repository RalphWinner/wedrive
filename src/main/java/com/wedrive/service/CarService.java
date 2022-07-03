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
    Car updateCar(Car car);
    Boolean isCarExist(Long id);
    void deleteCar(Long id);
}
