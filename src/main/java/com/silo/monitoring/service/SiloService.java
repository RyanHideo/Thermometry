package com.silo.monitoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.silo.monitoring.repository.SiloRepository;
import com.silo.monitoring.entity.Silo;
import java.util.List;

@Service
public class SiloService {
    @Autowired
    private SiloRepository siloRepository;
    
    public List<Silo> getAllSilos() {
        return siloRepository.findAll();
    }
}
