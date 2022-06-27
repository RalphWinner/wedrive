package com.wedrive.service.impl;

import com.wedrive.model.Rental;
import com.wedrive.repository.RentalRepository;
import com.wedrive.service.RentalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalServiceImpl implements RentalService {

    private final RentalRepository rentalRepository;

    public RentalServiceImpl(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public String saveRental(Rental rental)
    {
        rentalRepository.save(rental);
        return "Saved";
    }

    @Override
    public List<Rental> findAllRental() {
        return rentalRepository.findAll();
    }

    @Override
    public Rental findRentalByID(Long id) {
        return rentalRepository.findById(id).get();
    }


}
