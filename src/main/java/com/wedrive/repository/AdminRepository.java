package com.wedrive.repository;

import com.wedrive.model.Admin;
import com.wedrive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    public Admin findByUser(User user);
}
