package com.upwirk.upwirk_backend.services;

import com.upwirk.upwirk_backend.models.Rates;
import com.upwirk.upwirk_backend.models.SocialMediaProfiles;
import com.upwirk.upwirk_backend.models.User;

import java.util.List;

public interface CreateUserService {
    User createUserProfile(
            String name,
            String email,
            String password,
            String userType,
            String bio,
            List<SocialMediaProfiles> socialMediaProfiles,
            List<Rates> rates) throws Exception;

    // Other user management methods
}

