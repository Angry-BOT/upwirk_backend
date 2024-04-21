package com.upwirk.upwirk_backend.models;

import org.springframework.stereotype.Component;

@Component
public class SearchCriteria {
    private String category;
    private String location;
    private String pricingModel;
    private Double minPrice;
    private Double maxPrice;
    private Long minFollowers;
    private Long maxFollowers;
    private String availabilityStart;
    private String availabilityEnd;

    public void setArtistCategory(String category) {
        this.category = category;
    }
    public String getArtistCategory() {
        return this.category;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    public String getLocation() {
        return this.location;
    }
    public void setMinFollowers(Long minFollowers) {
        this.minFollowers = minFollowers;
    }
    public Long getMinFollowers() {
        return this.minFollowers;
    }
    public void setMaxFollowers(Long maxFollowers) {
        this.maxFollowers = maxFollowers;
    }
    public Long getMaxFollowers() {
        return this.maxFollowers;
    }
    public void setAvailibilityStart(String availabilityStart) {
        this.availabilityStart = availabilityStart;
    }
    public String getAvailibilityStart() {
        return this.availabilityStart;
    }
    public void setAvailibilityEnd(String availabilityEnd) {
        this.availabilityEnd = availabilityEnd;
    }
    public String getAvailibilityEnd() {
        return this.availabilityEnd;
    }
    public void setPricingModel(String pricingModel) {
        this.pricingModel = pricingModel;
    }
    public String getPricingModel() {
        return this.pricingModel;
    }
    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }
    public Double getMinPrice() {
        return this.minPrice;
    }
    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }
    public Double getMaxPrice() {
        return this.maxPrice;
    }
}