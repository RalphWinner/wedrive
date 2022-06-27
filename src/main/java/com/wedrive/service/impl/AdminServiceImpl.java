package com.wedrive.service.impl;

import com.wedrive.model.Admin;
import com.wedrive.model.User;
import com.wedrive.repository.AdminRepository;
import com.wedrive.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public String saveAdmin(Admin admin) {
        User user = admin.getUser();
        admin.setUser(user);
        adminRepository.save(admin);
        return "Saved";
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
}
