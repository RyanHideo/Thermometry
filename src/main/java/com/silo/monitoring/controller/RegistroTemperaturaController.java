package com.silo.monitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.silo.monitoring.service.RegistroTemperaturaService;
import com.silo.monitoring.entity.RegistroTemperatura;
import java.util.List;

@RestController
@RequestMapping("/api/temperaturas")
public class RegistroTemperaturaController {
    @Autowired
    private RegistroTemperaturaService registroTemperaturaService;
    
    @GetMapping("/{siloId}")
    public List<RegistroTemperatura> getTemperaturas(@PathVariable Long siloId) {
        return registroTemperaturaService.getTemperaturasBySilo(siloId);
    }
}