package com.wedrive.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.temporal.Temporal;
import java.util.*;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Table(name = "rental")
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rental_id;
    @Column(name = "status")
    private String status = "On Hold";
    @Column(name = "start_date")
    private Date start_date;
    @Column(name = "end_date")
    private Date end_date;
    @Column(name = "amount")
    private float amount;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "car_id")
    private Car car;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        try{
            long noOfDaysBetween = DAYS.between((Temporal) this.start_date, (Temporal) this.end_date);
            this.amount = amount*noOfDaysBetween;
        }catch (Exception e){
            this.amount = 0;
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public long getRental_id() {
        return rental_id;
    }

    public void setRental_id(long rental_id) {
        this.rental_id = rental_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

}
