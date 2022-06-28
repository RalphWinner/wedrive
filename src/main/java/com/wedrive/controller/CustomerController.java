package com.wedrive.controller;

import com.wedrive.model.Customer;
import com.wedrive.model.User;
import com.wedrive.service.CustomerService;
import com.wedrive.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final UserService userService;

    public CustomerController(CustomerService customerService, UserService userService) {
        this.customerService = customerService;
        this.userService = userService;
    }

    @GetMapping("/")
    public List<Customer> findAllCustomer(){
        return customerService.findAllCustomer();
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody Customer customer)
    {
        try {
            User user =customer.getUser();
            if(!userService.checkEmail(user)){
                return "Cannot save, Email already Exist or not valid -> " + user.getEmail();
            }else if(!userService.checkSSN(user)){
                return "Cannot save, SSN already Exist or not valid -> " + user.getSsn();
            }

            return customerService.saveCustomer(customer);
        }catch (Exception e){
            return "Cannot save Customer -> " + e.toString();
        }
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
