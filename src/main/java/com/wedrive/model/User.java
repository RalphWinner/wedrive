package com.wedrive.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long user_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email")
    private String email;
    @Column(name = "ssn")
    private String ssn;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "createdAt")
    private String createdAt;
    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JsonManagedReference
    private Admin admin;

    public User(){

    }

    public User(long user_id, String first_name, String last_name, String email, String ssn, String phone_number, String createdAt, String password, Customer customer, Admin admin) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.ssn = ssn;
        this.phone_number = phone_number;
        this.createdAt = createdAt;
        this.password = password;
        this.customer = customer;
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
