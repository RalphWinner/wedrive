package com.wedrive.service;

import com.wedrive.model.Customer;
import com.wedrive.model.User;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAllCustomer();
    Optional<Customer> findByID(Long id);
    String saveCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(Long id);
}
