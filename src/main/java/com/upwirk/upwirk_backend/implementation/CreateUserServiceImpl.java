package com.upwirk.upwirk_backend.implementation;

import com.upwirk.upwirk_backend.controller.CreateUserServiceController;
import com.upwirk.upwirk_backend.core.PasswordEncoder;
import com.upwirk.upwirk_backend.models.Rates;
import com.upwirk.upwirk_backend.models.SocialMediaProfiles;
import com.upwirk.upwirk_backend.models.User;
import com.upwirk.upwirk_backend.repositories.RatesRepository;
import com.upwirk.upwirk_backend.repositories.SocialMediaProfilesRepository;
import com.upwirk.upwirk_backend.repositories.UserRepository;
import com.upwirk.upwirk_backend.services.CreateUserService;
import jakarta.persistence.EntityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
@Service
public class CreateUserServiceImpl implements CreateUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SocialMediaProfilesRepository socialMediaProfilesRepository;
    @Autowired
    private RatesRepository ratesRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EntityManager entityManager;
    Logger logger = LoggerFactory.getLogger(CreateUserServiceImpl.class);
    public boolean existsByEmail(String email) {
        return !entityManager.createQuery("SELECT u.email FROM User u WHERE u.email = :email")
                .setParameter("email", email)
                .getResultList()
                .isEmpty();
    }
    @Override
    public User createUserProfile(String name, String email, String password, String userType, String bio, List<SocialMediaProfiles> socialMediaProfiles, List<Rates> rates) throws Exception {
        // Create user object
        User user = new User();
        try {
            // Save user information with proper setters
            logger.debug("Saving User Object for New User : " + name);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(passwordEncoder.encode(password));
            user.setUserType(userType);
            user.setBio(bio);
            user.setCreatedAt(new Date());
            user.setUpdatedAt(new Date());
            user.setCreatedBy(name);
            user.setUpdatedBy(name);
            userRepository.save(user);
            logger.debug("Saved User Object successfully for New User : " + name);
            // Handle rates (if rates is not null)
            if (rates != null) {
                logger.debug("Saving Rates Object for New User : " + name + " Id : " + user.getId());
                rates.stream()
                        .map(inputRate -> {
                            Rates userRates = new Rates();
                            userRates.setPricingModel(inputRate.getPricingModel());
                            userRates.setRate(inputRate.getRate());
                            userRates.setUser(user);
                            userRates.setCreatedAt(new Date());
                            userRates.setUpdatedAt(new Date());
                            userRates.setCreatedBy(name);
                            userRates.setUpdatedBy(name);
                            return userRates;
                        })
                        .forEach(ratesRepository::save);
                logger.debug("Saved Rates Object successfully for New User : " + name + " Id : " + user.getId());
            }
            // Handle social media profiles (if socialMediaProfiles is not null)
            if (socialMediaProfiles != null) {
                logger.debug("Saving Social Media Profiles Object for New User : " + name + " Id : " + user.getId());
                socialMediaProfiles.stream()
                        .map(inputProfile -> {
                            SocialMediaProfiles userProfiles = new SocialMediaProfiles();
                            userProfiles.setPlatform(inputProfile.getPlatform());
                            userProfiles.setUsername(inputProfile.getUsername());
                            userProfiles.setFollowerCount(inputProfile.getFollowerCount());
                            userProfiles.setUser(user);
                            userProfiles.setCreatedAt(new Date());
                            userProfiles.setUpdatedAt(new Date());
                            userProfiles.setCreatedBy(name);
                            userProfiles.setUpdatedBy(name);
                            return userProfiles;
                        })
                        .forEach(socialMediaProfilesRepository::save);
                logger.debug("Saved Social Media Profiles Object successfully for New User : " + name + " Id : " + user.getId());
            }
            return user;
        } catch (Exception e) {
            // Handle any potential exceptions during user creation or saving
            throw new Exception("Error creating user profile: " + e.getMessage());
        }
    }

    /*@Override
    public void sendWelcomeEmail(ArtistInfluencer artistInfluencer) {
        // Implement logic to send a welcome email to the artist/influencer
        // You'll need to configure your email sending service
        // ...
    }*/

    // Other user management methods (e.g., user registration, login)
}
