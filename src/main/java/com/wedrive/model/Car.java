package com.wedrive.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long car_id;

    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "last_service_date")
    private Date last_service_date;
    @Column(name = "mileage")
    private int mileage;
    @Column(name = "color")
    private String color;
    @Column(name="year")
    private String year;
    @Column(name = "max_capacity")
    private int max_capacity;
    @Column(name = "max_bag_allow")
    private int max_bag_allow;
    @Column(name = "price_per_day")
    private float price_per_day;
    @Column(name = "is_rent")
    private Boolean is_rent=false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insertBy", referencedColumnName = "admin_id")
    private Admin insertBy;

    @JsonIgnore
    @OneToMany(mappedBy = "car")
    Set<Rental> rentals = new HashSet<>();

    public Car() {

    }

    public Boolean getIs_rent() {
        return is_rent;
    }

    public float getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(float price_per_day) {
        this.price_per_day = price_per_day;
    }

    public void setIs_rent(Boolean is_rent) {
        this.is_rent = is_rent;
    }

    public Admin getInsertBy() {
        return insertBy;
    }

    public void setInsertBy(Admin insertBy) {
        this.insertBy = insertBy;
    }

    public Car(long car_id, String brand, String model, Date last_service_date, int mileage, String color, String year, int max_capacity, int max_bag_allow, boolean is_rent) {
        this.car_id = car_id;
        this.brand = brand;
        this.model = model;
        this.last_service_date = last_service_date;
        this.mileage = mileage;
        this.color = color;
        this.year = year;
        this.max_capacity = max_capacity;
        this.max_bag_allow = max_bag_allow;
        this.is_rent = is_rent;
    }

    public Set<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }

    public long getCar_id() {
        return car_id;
    }

    public void setCar_id(long car_id) {
        this.car_id = car_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Date getLast_service_date() {
        return last_service_date;
    }

    public void setLast_service_date(Date last_service_date) {
        this.last_service_date = last_service_date;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public int getMax_bag_allow() {
        return max_bag_allow;
    }

    public void setMax_bag_allow(int max_bag_allow) {
        this.max_bag_allow = max_bag_allow;
    }
}
