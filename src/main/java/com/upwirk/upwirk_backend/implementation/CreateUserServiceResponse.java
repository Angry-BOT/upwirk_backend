package com.upwirk.upwirk_backend.implementation;

public class CreateUserServiceResponse {
    private Long userId;
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public CreateUserServiceResponse(Long userId) {
        this.userId = userId;
    }
}

