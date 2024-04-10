package com.upwirk.upwirk_backend.response;

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

