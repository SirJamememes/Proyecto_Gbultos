package com.isl.webapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "locales")
@Data
public class Local {

    @Id
    @Column(length = 4)
    private String codigo;  // Código de 4 dígitos, ID principal

    @Column(nullable = false)
    private String nombre;  // Nombre principal

    private String nombreAlternativo;

    private String zona;  // Ej: "Norte", "Centro", etc.

    private String codigoInterno;  // Otro identificador del local
}