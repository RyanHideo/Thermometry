package com.silo.monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.silo.monitoring.entity.Silo;

public interface SiloRepository extends JpaRepository<Silo, Long> {
}
