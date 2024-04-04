package com.upwirk.create;

public class CreateUserResponse {

    private Long userId;

    public CreateUserResponse(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
// Getters (omitted for brevity)
}

