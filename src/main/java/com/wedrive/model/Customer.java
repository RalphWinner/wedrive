package com.wedrive.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customer_id;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
    @Column(name = "address")
    private String address;
    @Column(name = "driver_licence")
    private String driver_licence;

    public Customer(){

    }

    public Customer(User user, String address, String driver_licence) {
        this.user = user;
        this.address = address;
        this.driver_licence = driver_licence;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDriver_licence() {
        return driver_licence;
    }

    public void setDriver_licence(String driver_licence) {
        this.driver_licence = driver_licence;
    }
}
