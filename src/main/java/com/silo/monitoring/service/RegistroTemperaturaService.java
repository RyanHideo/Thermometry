package com.silo.monitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.silo.monitoring.repository.RegistroTemperaturaRepository;
import com.silo.monitoring.entity.RegistroTemperatura;
import java.util.List;

@Service
public class RegistroTemperaturaService {
    @Autowired
    private RegistroTemperaturaRepository registroTemperaturaRepository;
    
    public List<RegistroTemperatura> getTemperaturasBySilo(Long siloId) {
        return registroTemperaturaRepository.findBySiloId(siloId);
    }
}
