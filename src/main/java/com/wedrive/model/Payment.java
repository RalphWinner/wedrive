package com.wedrive.model;

import javax.persistence.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;

import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Table(name = "payment")
public class Payment {
    private static final float TAXE = 0.092f;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long payment_id;

    @Column(name = "amount")
    private float amount;
    @Column(name = "payment_transaction_number")
    private String payment_transaction_number;
    @OneToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;

    public long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount() {
        try{
            long noOfDaysBetween = ChronoUnit.DAYS.between(rental.getStart_date(), rental.getEnd_date());
            this.amount = this.rental.getCar().getPrice_per_day()*noOfDaysBetween;
            this.amount*=(1 + TAXE);
        }catch (Exception e){
            this.amount = 0;
        }
    }

    public String getPayment_transaction_number() {
        return payment_transaction_number;
    }

    public void setPayment_transaction_number(String payment_transaction_number) {
        this.payment_transaction_number = payment_transaction_number;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public Payment(long payment_id, float amount, String payment_transaction_number, Rental rental) {
        this.payment_id = payment_id;
        this.amount = amount;
        this.payment_transaction_number = payment_transaction_number;
        this.rental = rental;
    }

    public Payment() {
    }
}
