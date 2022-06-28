package com.wedrive.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wedrive.model.Car;
import com.wedrive.model.Customer;
import com.wedrive.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> findAllCustomer(){
        return customerService.findAllCustomer();
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @PutMapping("")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
    }

}
