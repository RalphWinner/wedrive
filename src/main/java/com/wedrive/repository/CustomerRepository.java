package com.wedrive.repository;

import com.wedrive.model.Admin;
import com.wedrive.model.Customer;
import com.wedrive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    public Customer findByUser(User user);
}
