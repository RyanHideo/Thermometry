package com.silo.monitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.silo.monitoring.service.SiloService;
import com.silo.monitoring.entity.Silo;
import java.util.List;

@RestController
@RequestMapping("/api/silos")
public class SiloController {
    @Autowired
    private SiloService siloService;
    
    @GetMapping
    public List<Silo> getAllSilos() {
        return siloService.getAllSilos();
    }
}