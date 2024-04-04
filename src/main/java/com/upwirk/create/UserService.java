package com.upwirk.create;

import com.upwirk.pojos.Rates;
import com.upwirk.pojos.SocialMediaLinks;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {
    User createUserProfile(
            String name,
            String bio,
            Integer categoryId,
            List<String> portfolioUrls,
            SocialMediaLinks socialMediaLinks,
            Rates rates,
            List<MultipartFile> images) throws IOException;

    // Other user management methods (omitted for brevity)
}

