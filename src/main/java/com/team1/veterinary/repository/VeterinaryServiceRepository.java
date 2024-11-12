package com.team1.veterinary.repository;

import com.team1.veterinary.model.VeterinaryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinaryServiceRepository extends JpaRepository<VeterinaryService, Long> {
}
