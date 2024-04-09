package com.upwirk.upwirk_backend.models;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "users")
public class User extends SanityFields{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "user_type")// Hashed password
    private String userType;
    @Column(name = "bio")// Enum (CLIENT, ARTIST)
    private String bio;
    @ManyToOne
    @JoinColumn(name = "fk_category_id", referencedColumnName = "id")
    private Category category; // Foreign key referencing categories table
    @ManyToOne
    @JoinColumn(name = "fk_rate_id", referencedColumnName = "id")
    private Rates rates; // Foreign key referencing rates table

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public Category getCategoryId() {
        return category;
    }
    public void setCategoryId(Category category) {
        this.category = category;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public Rates getRates() {
        return rates;
    }
    public void setRates(Rates rates) {
        this.rates = rates;
    }

}
