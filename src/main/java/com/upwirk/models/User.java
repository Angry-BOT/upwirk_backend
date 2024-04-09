package com.upwirk.pojos;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.hibernate.usertype.UserType;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    private Long id;
    private String name;
    private String email;
    private String password; // Hashed password
    private UserType userType; // Enum (CLIENT, ARTIST)
    private Integer categoryId; // Foreign key referencing Categories table
    private String bio;
    private List<String> portfolioUrls;
    private SocialMediaLinks socialMediaLinks;
    private Rates rates;
    private Double averageRating;
    private Date createdAt;
    private Date updatedAt;

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<String> getPortfolioUrls() {
        return portfolioUrls;
    }

    public void setPortfolioUrls(List<String> portfolioUrls) {
        this.portfolioUrls = portfolioUrls;
    }

    public SocialMediaLinks getSocialMediaLinks() {
        return socialMediaLinks;
    }

    public void setSocialMediaLinks(SocialMediaLinks socialMediaLinks) {
        this.socialMediaLinks = socialMediaLinks;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
}
