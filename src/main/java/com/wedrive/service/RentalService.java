package com.wedrive.service;

import com.wedrive.model.Car;
import com.wedrive.model.Rental;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RentalService {
    Rental saveRental(Rental rental);

    List<Rental> findAllRental();

    Rental findRentalByID(Long id);
    Boolean isCarRent(Car car);
    Boolean checkDateisGood(LocalDateTime startDate, LocalDateTime endDate);
}
