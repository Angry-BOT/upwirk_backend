package com.upwirk.upwirk_backend.repositories;

import com.upwirk.upwirk_backend.models.SocialMediaProfiles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialMediaProfilesRepository extends JpaRepository<SocialMediaProfiles, Long> {
}
