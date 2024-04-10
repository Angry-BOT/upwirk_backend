package com.upwirk.upwirk_backend.repositories;

import com.upwirk.upwirk_backend.models.Rates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatesRepository extends JpaRepository<Rates, Long> {
}
