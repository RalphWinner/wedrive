package com.wedrive.service;

import com.wedrive.model.Admin;

import java.util.List;

public interface AdminService {
    String saveAdmin(Admin admin);
    List<Admin> findAllAdmin();
    Admin findAdminbyID(Long id);
}
