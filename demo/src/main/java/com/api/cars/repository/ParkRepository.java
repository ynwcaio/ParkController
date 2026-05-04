package com.api.cars.repository;

import com.api.cars.model.entities.Park;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParkRepository extends JpaRepository<Park, UUID> {
}
