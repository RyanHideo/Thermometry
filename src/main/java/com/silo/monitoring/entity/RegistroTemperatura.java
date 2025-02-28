package com.silo.monitoring.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "registro_temperaturas")
@Getter
@Setter
public class RegistroTemperatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private Long siloId;
    
    @Column(nullable = false)
    private String sensor;
    
    @Column(nullable = false)
    private Double temperatura;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRegistro;
}
