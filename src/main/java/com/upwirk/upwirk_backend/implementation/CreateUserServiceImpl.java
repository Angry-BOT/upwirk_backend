package com.upwirk.upwirk_backend.implementation;

import com.upwirk.upwirk_backend.core.PasswordEncoder;
import com.upwirk.upwirk_backend.models.Rates;
import com.upwirk.upwirk_backend.models.SocialMediaProfiles;
import com.upwirk.upwirk_backend.models.User;
import com.upwirk.upwirk_backend.repositories.SocialMediaProfilesRepository;
import com.upwirk.upwirk_backend.repositories.UserRepository;
import com.upwirk.upwirk_backend.services.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateUserServiceImpl implements CreateUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SocialMediaProfilesRepository socialMediaProfilesRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User createUserProfile(String name, String email, String password, String userType, String bio, List<SocialMediaProfiles> socialMediaProfiles, Rates rates) {

        User user = new User();
        SocialMediaProfiles userProfiles = new SocialMediaProfiles();
        String createdUpdatedBy = user.getName();
        // Check if user already has an artist/influencer profile
        if (UserRepository.existsByUserId(user.getId())) {
            throw new IllegalArgumentException("User already has a profile");
        }
        // Save user information
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setUserType(userType);
        user.setBio(bio);
        user.setRates(rates);
        user.setCreatedBy(name);
        user.setUpdatedBy(name);
        userRepository.save(user);
        socialMediaProfiles.stream()
                .map(profile -> {
                    userProfiles.setPlatform(profile.getPlatform());
                    userProfiles.setFollower_count(profile.getFollower_count());
                    userProfiles.setUser(user);
                    userProfiles.setCreatedBy(createdUpdatedBy);
                    userProfiles.setUpdatedBy(createdUpdatedBy);
                    return userProfiles;
                })
                .forEach(socialMediaProfilesRepository::save);

         /*Handle image uploads
         You'll need logic to:
         - Validate image formats and sizes
         - Generate unique file names
         - Save images to a secure location (e.g., cloud storage)
         - Update artistInfluencer with image URLs or references*/

        return user;
    }

    /*@Override
    public void sendWelcomeEmail(ArtistInfluencer artistInfluencer) {
        // Implement logic to send a welcome email to the artist/influencer
        // You'll need to configure your email sending service
        // ...
    }*/

    // Other user management methods (e.g., user registration, login)
}
