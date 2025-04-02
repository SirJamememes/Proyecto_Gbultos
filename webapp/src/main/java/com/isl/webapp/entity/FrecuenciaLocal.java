package com.isl.webapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "frecuencia_local")
@Data
public class FrecuenciaLocal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "codigo_local", nullable = false)
    private Local local;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiaSemana dia;

    
}
