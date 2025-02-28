package com.silo.monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.silo.monitoring.entity.RegistroTemperatura;
import java.util.List;

public interface RegistroTemperaturaRepository extends JpaRepository<RegistroTemperatura, Long> {
    List<RegistroTemperatura> findBySiloId(Long siloId);
}
