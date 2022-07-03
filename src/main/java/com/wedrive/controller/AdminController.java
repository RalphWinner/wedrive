package com.wedrive.controller;

import com.wedrive.model.Admin;
import com.wedrive.model.Car;
import com.wedrive.model.Rental;
import com.wedrive.model.User;
import com.wedrive.service.AdminService;
import com.wedrive.service.CarService;
import com.wedrive.service.RentalService;
import com.wedrive.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    private final AdminService adminService;
    private final RentalService rentalService;
    private final CarService carService;
    private final UserService userService;

    public AdminController(AdminService adminService, RentalService rentalService, CarService carService, UserService userService) {
        this.adminService = adminService;
        this.rentalService = rentalService;
        this.carService = carService;
        this.userService = userService;
    }

    String HelloWorld()
    {
        return "Hello to the WORLD!";
    }
    @PutMapping("/update")
    String editAdmin(@RequestBody Admin admin)
    {
        try {
            if(admin.getAdmin_id() == null){
                return "Cannot update, please provide an Admin ID";
            }else if(!adminService.isAdminExist(admin.getAdmin_id())){
                return "Cannot update, Admin ID not exist";
            }

            User user = admin.getUser();
            user.setUser_type("Admin");

            return adminService.saveAdmin(admin);
        }catch (Exception e){
            return "Cannot update Admin -> " + e.toString();
        }
    }

    @PostMapping("/save")
    String saveAdmin(@RequestBody Admin admin)
    {
        try {
        User user = admin.getUser();
        if(!userService.checkEmail(user)){
            return "Cannot save, Email already Exist or not valid -> " + user.getEmail();
        }else if(!adminService.checkSSN(admin)){
            return "Cannot save, SSN already Exist or not valid -> " + admin.getSsn();
        }
            user.setUser_type("Admin");
            admin.setUser(user);

            SendEmail sendEmail = new SendEmail();
            sendEmail.SendingEMail("Welcome to WeDrive MPP Project", "Your account have been created succesfully!!"
                    , user.getEmail(), user.getFirst_name() + " " + user.getLast_name());

            return adminService.saveAdmin(admin);
        }catch (Exception e){
            return "Cannot save Admin -> " + e.toString();
        }
    }

    @PostMapping("/approve_denied/{rental_id}/{approve_denied}")
    String approve_denied_rental(@PathVariable Long rental_id, @PathVariable int approve_denied)
    {
        Rental rental = rentalService.findRentalByID(rental_id);
        Car car = rental.getCar();

        rental.setStatus("Approved");
        car.setIs_rent(approve_denied == 1);
        if(approve_denied == 1){
            rental.setStatus("Approve");
        }else if (approve_denied == 0){
            rental.setStatus("Denied");
            car.setIs_rent(false);
        }
        carService.updateCar(car);
        rentalService.saveRental(rental);

        SendEmail sendEmail = new SendEmail();
        sendEmail.SendingEMail("WeDrive MPP Project Rental Admin Approval", "Your rental have been "+ rental.getStatus() +"."
                , rental.getCustomer().getUser().getEmail(), rental.getCustomer().getUser().getFirst_name() + " " + rental.getCustomer().getUser().getLast_name());

        return "Rental Approved";
    }

    @GetMapping("/")
    List<Admin> findAllAdmin(){
        return adminService.findAllAdmin();
    }
}
