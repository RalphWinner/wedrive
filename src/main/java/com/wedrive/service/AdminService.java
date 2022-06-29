package com.wedrive.service;

import com.wedrive.model.Admin;
import com.wedrive.model.User;

import java.util.List;

public interface AdminService {
    String saveAdmin(Admin admin);
    List<Admin> findAllAdmin();
    Admin findAdminbyID(Long id);
    Boolean checkSSN(Admin admin);
}
