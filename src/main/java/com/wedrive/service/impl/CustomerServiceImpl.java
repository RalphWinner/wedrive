package com.wedrive.service.impl;

import com.wedrive.model.Customer;
import com.wedrive.model.User;
import com.wedrive.repository.CustomerRepository;
import com.wedrive.service.CustomerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> findByID(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public String saveCustomer(Customer customer)
    {
        User user = customer.getUser();
        user.setCustomer(customer);
        user.setCreatedAt(LocalDateTime.now());
        customerRepository.save(customer);
        return "Saved";
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findCustomerbyUserID(User user) {
        return customerRepository.findByUser(user);
    }
}
