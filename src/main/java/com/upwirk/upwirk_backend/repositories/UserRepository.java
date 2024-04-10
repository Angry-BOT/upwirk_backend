package com.upwirk.upwirk_backend.repositories;

import com.upwirk.upwirk_backend.models.User;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {

}
