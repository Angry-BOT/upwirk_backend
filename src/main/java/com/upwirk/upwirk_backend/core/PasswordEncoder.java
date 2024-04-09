package com.upwirk.upwirk_backend.core;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder {
    private static final int STRENGTH = 10; // Adjust strength as needed
    public String encode(CharSequence rawPassword) {
        String salt = BCrypt.gensalt(STRENGTH); // Generate a random salt
        return BCrypt.hashpw(rawPassword.toString(), salt); // Hash password with salt
    }
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword.toString(), encodedPassword); // Compare hashed passwords
    }
}
