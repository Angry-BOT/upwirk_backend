package com.upwirk.pojos;

public class Rates {
    private String pricingModel; // Enum (HOURLY, FIXED)
    private Double rate;

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
