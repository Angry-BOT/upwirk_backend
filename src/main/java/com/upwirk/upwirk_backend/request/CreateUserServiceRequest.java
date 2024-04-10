package com.upwirk.upwirk_backend.request;

import com.upwirk.upwirk_backend.models.Rates;
import com.upwirk.upwirk_backend.models.SocialMediaProfiles;

import java.util.List;

public class CreateUserServiceRequest {
    private String name;
    private String email;
    private String password;
    private String userType;
    private String bio;
    private List<SocialMediaProfiles> socialMediaProfiles;
    private List<Rates> rates;

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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<SocialMediaProfiles> getSocialMediaProfiles() {
        return socialMediaProfiles;
    }

    public void setSocialMediaProfiles(List<SocialMediaProfiles> socialMediaProfiles) {
        this.socialMediaProfiles = socialMediaProfiles;
    }

    public List<Rates> getRates() {
        return rates;
    }

    public void setRates(List<Rates> rates) {
        this.rates = rates;
    }
}
