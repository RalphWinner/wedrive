package com.wedrive.service;

import com.wedrive.model.Rental;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RentalService {
    String saveRental(Rental rental);

    List<Rental> findAllRental();

    Rental findRentalByID(Long id);
}
