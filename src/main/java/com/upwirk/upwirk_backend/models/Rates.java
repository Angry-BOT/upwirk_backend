package com.upwirk.upwirk_backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Entity
@Table(name = "rates")
public class Rates {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "story")
    private Integer storyRate;

    @Column(name = "post")
    private Integer postRate;

    @Column(name = "ugc_product_video")
    private Integer ugcProductVideoRate;

    @Column(name = "ugc_product_photo")
    private Integer ugcProductPhotoRate;

    @Column(name = "ugc_onboxing")
    private Integer ugcOnboxingRate;

    @Column(name = "ugc_photo_ad")
    private Integer ugcPhotoAdRate;

    @Column(name = "ugc_video_ad")
    private Integer ugcVideoAdRate;

    @Column(name = "ugc_review_testimonial")
    private Integer ugcReviewTestimonialRate;

    @Column(name = "instagram_story_ad")
    private Integer instagramStoryAdRate;

    @Column(name = "instagram_post_ad")
    private Integer instagramPostAdRate;

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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStoryRate() {
        return storyRate;
    }

    public void setStoryRate(Integer storyRate) {
        this.storyRate = storyRate;
    }

    public Integer getPostRate() {
        return postRate;
    }

    public void setPostRate(Integer postRate) {
        this.postRate = postRate;
    }

    public Integer getUgcProductVideoRate() {
        return ugcProductVideoRate;
    }

    public void setUgcProductVideoRate(Integer ugcProductVideoRate) {
        this.ugcProductVideoRate = ugcProductVideoRate;
    }

    public Integer getUgcProductPhotoRate() {
        return ugcProductPhotoRate;
    }

    public void setUgcProductPhotoRate(Integer ugcProductPhotoRate) {
        this.ugcProductPhotoRate = ugcProductPhotoRate;
    }

    public Integer getUgcOnboxingRate() {
        return ugcOnboxingRate;
    }

    public void setUgcOnboxingRate(Integer ugcOnboxingRate) {
        this.ugcOnboxingRate = ugcOnboxingRate;
    }

    public Integer getUgcPhotoAdRate() {
        return ugcPhotoAdRate;
    }

    public void setUgcPhotoAdRate(Integer ugcPhotoAdRate) {
        this.ugcPhotoAdRate = ugcPhotoAdRate;
    }

    public Integer getUgcVideoAdRate() {
        return ugcVideoAdRate;
    }

    public void setUgcVideoAdRate(Integer ugcVideoAdRate) {
        this.ugcVideoAdRate = ugcVideoAdRate;
    }

    public Integer getUgcReviewTestimonialRate() {
        return ugcReviewTestimonialRate;
    }

    public void setUgcReviewTestimonialRate(Integer ugcReviewTestimonialRate) {
        this.ugcReviewTestimonialRate = ugcReviewTestimonialRate;
    }

    public Integer getInstagramStoryAdRate() {
        return instagramStoryAdRate;
    }

    public void setInstagramStoryAdRate(Integer instagramStoryAdRate) {
        this.instagramStoryAdRate = instagramStoryAdRate;
    }

    public Integer getInstagramPostAdRate() {
        return instagramPostAdRate;
    }

    public void setInstagramPostAdRate(Integer instagramPostAdRate) {
        this.instagramPostAdRate = instagramPostAdRate;
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
}
