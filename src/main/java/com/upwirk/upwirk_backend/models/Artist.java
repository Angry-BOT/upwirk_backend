package com.upwirk.upwirk_backend.models;


import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "city", length = 255)
    private String city;

    @Column(name = "state", length = 255)
    private String state;

    @Column(name = "age")
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 2)
    private Gender gender;

    @Column(name = "social_media_data")
    private String socialMediaData;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_category_id")
    private Category category; // Assuming Category class exists

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_rates_id")
    private Rates rates;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    @Column(name = "isDeleted", nullable = false)
    @ColumnDefault("false")
    private boolean deleted;

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getSocialMediaData() {
        return socialMediaData;
    }

    public Category getCategory() {
        return category;
    }

    public Rates getRates() {
        return rates;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setSocialMediaData(String socialMediaData) {
        this.socialMediaData = socialMediaData;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public enum Gender {
        M, F, O, NA;
    }
}
