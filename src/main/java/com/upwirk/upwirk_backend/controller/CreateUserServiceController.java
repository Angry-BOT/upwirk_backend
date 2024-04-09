package com.upwirk.upwirk_backend.controller;

import com.upwirk.upwirk_backend.implementation.CreateUserServiceResponse;
import com.upwirk.upwirk_backend.models.Rates;
import com.upwirk.upwirk_backend.models.SocialMediaProfiles;
import com.upwirk.upwirk_backend.models.User;
import com.upwirk.upwirk_backend.implementation.CreateUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/create")
public class CreateUserServiceController {
    @Autowired
    public CreateUserServiceImpl userService;
    /*@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)*/
    public ResponseEntity<CreateUserServiceResponse> createProfile(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String userType,
            @RequestParam String bio,
            @RequestParam(required = false) List<SocialMediaProfiles> socialMediaProfiles,
            @RequestParam(required = false) Rates rates
            /*@RequestPart(name = "images", required = false) List<MultipartFile> images*/) throws IOException {

        /*// Check if user is already registered as a client (not allowed to create artist profile)
        if (currentUser.getUserType() == UserType.CLIENT) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }*/
        User user = userService.createUserProfile(name, email, password, userType, bio, socialMediaProfiles, rates);
        CreateUserServiceResponse response = new CreateUserServiceResponse(user.getId());
        return ResponseEntity.ok(response);
    }

}
