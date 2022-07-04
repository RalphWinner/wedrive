package com.wedrive.service.impl;

import com.wedrive.model.Admin;
import com.wedrive.model.User;
import com.wedrive.repository.AdminRepository;
import com.wedrive.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;
    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public String saveAdmin(Admin admin) {
        User user = admin.getUser();
        user.setCreatedAt(LocalDateTime.now());
        admin.setUser(user);
        adminRepository.save(admin);
        return "Saved";
    }

    @Override
    public String editAdmin(Long ID) {
        return null;
    }

    @Override
    public List<Admin> findAllAdmin()
    {
        return adminRepository.findAll();
    }

    @Override
    public Admin findAdminbyID(Long id)
    {
        //findByID return a <optional> get() is to return the object
        return adminRepository.findById(id).get();
    }

    @Override
    public Boolean checkSSN(Admin admin) {
        String ssn = admin.getSsn();

        if(ssn == null || ssn.length() != 9){
            return false;
        }
        for(Admin tempAdmin: adminRepository.findAll()){
            if(tempAdmin.getSsn().equals(ssn)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isAdminExist(Long admin_id) {
        return adminRepository.existsById(admin_id);
    }

    @Override
    public Admin findAdminbyUserID(User user) {
        return adminRepository.findByUser(user);
    }
}
