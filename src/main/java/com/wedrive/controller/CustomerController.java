package com.wedrive.controller;

import com.wedrive.model.Customer;
import com.wedrive.model.Feedback;
import com.wedrive.model.Rental;
import com.wedrive.model.User;
import com.wedrive.service.CustomerService;
import com.wedrive.service.FeedbackService;
import com.wedrive.service.RentalService;
import com.wedrive.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final UserService userService;
    private final RentalService rentalService;
    private final FeedbackService feedbackService;

    public CustomerController(CustomerService customerService, UserService userService, RentalService rentalService, FeedbackService feedbackService) {
        this.customerService = customerService;
        this.userService = userService;
        this.rentalService = rentalService;
        this.feedbackService = feedbackService;
    }

    @GetMapping("/")
    public List<Customer> findAllCustomer(){
        return customerService.findAllCustomer();
    }
    @PostMapping("/createfeedback/{rental_id}")
    public String createFeedback(@RequestBody Feedback feedback, @PathVariable Long rental_id){
        Rental rental;
        try {
            rental = rentalService.findRentalByID(rental_id);
        }catch (Exception e){
            return "Error, Rental not Found -> " + e.toString();
        }

        if(feedback.getMessage().equals("")){
            return "Please, send a valid feedback";
        }
        feedback.setRental(rental);
        feedback.setFeedbackDate(LocalDateTime.now());
        feedbackService.saveFeedback(feedback);

        return "Saved";
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody Customer customer)
    {
        try {
            User user =customer.getUser();
            if(!userService.checkEmail(user)){
                return "Cannot save, Email already Exist or not valid -> " + user.getEmail();
            }
            user.setUser_type("Customer");
            customer.setUser(user);

            SendEmail sendEmail = new SendEmail();
            sendEmail.SendingEMail("Welcome to WeDrive MPP Project", "Your account have been created succesfully!!"
                    , user.getEmail(), user.getFirst_name() + " " + user.getLast_name());

            return customerService.saveCustomer(customer);
        }catch (Exception e){
            return "Cannot save Customer -> " + e.toString();
        }
    }

    @PutMapping("/update")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
    }

}
