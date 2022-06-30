package com.wedrive.service.impl;

import com.wedrive.model.Car;
import org.springframework.stereotype.Service;
import com.wedrive.repository.CarRepository;
import com.wedrive.service.CarService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAllCar() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findByID(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> findAllCarAvailable()
    {
        List<Car> carList = null;
        for (Car car: carRepository.findAll()){
            if(!car.getIs_rent()){
                carList.add(car);
            }
        }
        return carList;
    }

    @Override
    public Car saveCar(Car car)
    {
        return carRepository.save(car);
    }

    @Override
    public void updateCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
