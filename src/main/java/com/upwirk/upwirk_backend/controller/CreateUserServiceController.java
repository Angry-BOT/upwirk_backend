package com.upwirk.upwirk_backend.controller;

import com.upwirk.upwirk_backend.core.Sanity;
import com.upwirk.upwirk_backend.exceptions.UpwirdException;
import com.upwirk.upwirk_backend.request.CreateUserServiceRequest;
import com.upwirk.upwirk_backend.models.User;
import com.upwirk.upwirk_backend.implementation.CreateUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/create")
public class CreateUserServiceController {
    @Autowired
    public CreateUserServiceImpl userService;
    @Autowired
    public Sanity sanity;
    Logger logger = LoggerFactory.getLogger(CreateUserServiceController.class);
    public final String SUCCESS_MSG = "User registered successfully";
    /*@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)*/
    @PostMapping
    public ResponseEntity<String> createProfile(
            @RequestBody CreateUserServiceRequest request
            /*@RequestPart(name = "images", required = false) List<MultipartFile> images*/) {
        logger.debug("Initiating createUserProfile service...");
        try {
            // Validate mandatory fields
            if (sanity.isNullOrEmpty(request.getName()) ||
                    sanity.isNullOrEmpty(request.getEmail()) ||
                    sanity.isNullOrEmpty(request.getPassword()) ||
                    sanity.isNullOrEmpty(request.getUserType())) {
                throw new UpwirdException("Missing required fields: name, email, password, userType, bio");
            }
            logger.info("Required params successfully validated.");
            // Check if user already has a user profile (assuming email is not null)
            if (userService.existsByEmail(request.getEmail())) {
                throw new UpwirdException("User already has a profile with the email");
            }
            User user = userService.createUserProfile(
                    request.getName(),
                    request.getEmail(),
                    request.getPassword(),
                    request.getUserType(),
                    request.getBio(),
                    request.getSocialMediaProfiles(),
                    request.getRates()
            );
            logger.debug("Successfully created user profile : Id : " + user.getId() + " Name : " + request.getName() + " Email : " + request.getEmail());
            return ResponseEntity.ok(SUCCESS_MSG);
        } catch (UpwirdException e) {
            logger.error(e.getMessage() + Arrays.toString(e.getStackTrace()));
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage() + Arrays.toString(e.getStackTrace()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
