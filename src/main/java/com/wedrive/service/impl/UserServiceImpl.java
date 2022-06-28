package com.wedrive.service.impl;

import com.wedrive.model.Admin;
import com.wedrive.model.User;
import com.wedrive.repository.UserRepository;
import com.wedrive.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Boolean checkEmail(User user) {
        String email = user.getEmail();

        if(email == null || !email.contains("@")){
            return false;
        }
        for(User tempUser: userRepository.findAll()){
            if(tempUser.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Boolean checkSSN(User user) {
        String ssn = user.getSsn();

        if(ssn == null || ssn.length() != 9){
            return false;
        }
        for(User tempUser: userRepository.findAll()){
            if(tempUser.getSsn().equals(ssn)){
                return false;
            }
        }
        return true;
    }

    @Override
    public List<User> findAllUser() {
        return userRepository.findAll();
    }
}
