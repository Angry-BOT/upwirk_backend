package com.upwirk.upwirk_backend.models;

import jakarta.persistence.*;
@Entity
@Table(name = "rates")
public class Rates extends SanityFields{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "pricing_model")
    private String pricingModel; // Enum (HOURLY, FIXED)
    @Column(name = "rate")
    private Double rate;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getPricingModel() {
        return pricingModel;
    }
    public void setPricingModel(String pricingModel) {
        this.pricingModel = pricingModel;
    }
    public Double getRate() {
        return rate;
    }
    public void setRate(Double rate) {
        this.rate = rate;
    }
}
