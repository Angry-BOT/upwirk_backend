package com.upwirk.upwirk_backend.models;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "campaign_applications")
public class CampaignApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "campaign_id", referencedColumnName = "id")
    private Campaign campaign; // Reference to Campaign object

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User applicant; // Reference to User object

    @Column(name = "message", length = 255)
    private String message;

    @Enumerated(EnumType.STRING) // Specify String storage for ENUM
    @Column(name = "status")
    private ApplicationStatus status; // Custom enum for application status

    @Column(name = "applied_at")
    private LocalDateTime appliedAt;

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

    public Campaign getCampaign() {
        return campaign;
    }

    public User getApplicants() {
        return applicant;
    }

    public String getMessage() {
        return message;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCampaign(Campaign campaign) {
        this.campaign = campaign;
    }

    public void setApplicants(User applicants) {
        this.applicant = applicants;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
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

    public enum ApplicationStatus {
        STARTED,
        SELECTED,
        REJECTED,
        INPROGRESS,
        COMPLETED,
        FINISHED;
    }
}