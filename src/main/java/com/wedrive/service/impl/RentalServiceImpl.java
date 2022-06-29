package com.wedrive.service.impl;

import com.wedrive.model.Car;
import com.wedrive.model.Rental;
import com.wedrive.repository.RentalRepository;
import com.wedrive.service.RentalService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public Rental saveRental(Rental rental)
    {
        return rentalRepository.save(rental);
    }

    @Override
    public List<Rental> findAllRental() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental findRentalByID(Long id) {
        return rentalRepository.findById(id).get();
    }

    @Override
    public Boolean isCarRent(Car car) {
        return car.getIs_rent();
    }

    @Override
    public Boolean checkDateisGood(LocalDateTime startDate, LocalDateTime endDate) {
        return ChronoUnit.DAYS.between(startDate, endDate) >= 1;
    }


}
