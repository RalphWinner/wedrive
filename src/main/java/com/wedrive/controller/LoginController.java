package com.wedrive.controller;

import com.wedrive.model.Customer;
import com.wedrive.service.AdminService;
import com.wedrive.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wedrive.model.User;
import com.wedrive.service.UserService;

@RestController
@RequestMapping("api/v1")
public class LoginController {

    private UserService userService;
    private AdminService adminService;
    private CustomerService customerService;


	@PostMapping(value = "/login")
	public String login(@RequestBody User user) {
		try {
			String email = user.getEmail();
			String password = user.getPassword();
			password = user.cryptPassword(password);
			return UserExistType(email, password);
		}catch (Exception e){
			return "Cannot Login in -> " + e.toString();
		}
    }

	private String UserExistType(String email, String password)
	{
		for (User tempuser: userService.findAllUser()){
			if(tempuser.getEmail().equals(email) && tempuser.getPassword().equals(password)){
				if(tempuser.getUser_type() == "Admin"){
					return "Admin";
				}else{
					return "Customer.1";
				}
			}
		}
		return "Credentials not Correct";
	}

}