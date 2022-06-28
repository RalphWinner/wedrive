package com.wedrive.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admin_id;
    @Column(name = "username")
    private String username;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "insertBy")
    Set<Car> cars = new HashSet<>();

    public Admin() {
    }

    public Admin(Long admin_id, String username, User user) {
        this.admin_id = admin_id;
        this.username = username;
        this.user = user;
    }
    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
