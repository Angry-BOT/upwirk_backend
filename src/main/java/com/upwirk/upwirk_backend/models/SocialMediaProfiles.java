package com.upwirk.upwirk_backend.models;

import jakarta.persistence.*;
@Entity
@Table(name = "social_media_profiles")
public class SocialMediaProfiles extends SanityFields{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fk_user_id", referencedColumnName = "id")
    private User user;
    @Column(name = "platform")
    private String platform;
    @Column(name = "follower_count")
    private int follower_count;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public int getFollower_count() {
        return follower_count;
    }
    public void setFollower_count(int follower_count) {
        this.follower_count = follower_count;
    }
}
