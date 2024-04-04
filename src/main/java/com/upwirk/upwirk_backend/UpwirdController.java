package com.upwirk.upwirk_backend;

import com.upwirk.create.CreateUserResponse;
import com.upwirk.create.UserService;
import com.upwirk.pojos.Rates;
import com.upwirk.pojos.SocialMediaLinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UpwirdController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CreateUserResponse> createProfile(
            @RequestParam String name,
            @RequestParam String bio,
            @RequestParam Integer categoryId,
            @RequestParam(required = false) List<String> portfolioUrls,
            @RequestParam(required = false) SocialMediaLinks socialMediaLinks,
            @RequestParam(required = false) Rates rates,
            @RequestPart(name = "images", required = false) List<MultipartFile> images) throws IOException {

        /*// Check if user is already registered as a client (not allowed to create artist profile)
        if (currentUser.getUserType() == UserType.CLIENT) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }*/

        User user = userService.createUserProfile(
                name, bio, categoryId, portfolioUrls, socialMediaLinks, rates, images);

        CreateUserResponse response = new CreateUserResponse(user.getId());
        return ResponseEntity.ok(response);
    }

}
