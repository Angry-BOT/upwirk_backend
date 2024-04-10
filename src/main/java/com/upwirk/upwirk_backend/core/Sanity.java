package com.upwirk.upwirk_backend.core;

import org.springframework.stereotype.Component;

@Component
public class Sanity {
    public boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty() || s.equalsIgnoreCase("null");
    }
}
