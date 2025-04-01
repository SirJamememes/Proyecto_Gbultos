package com.isl.webapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "control_despacho")
@Data
public class ControlDespacho {

    @Id
    @Column(length = 13)
    private String codigoControl;  // Ej: "20250329CTRL01"

    private LocalDate fechaDespacho;

    @OneToMany(mappedBy = "controlDespacho", cascade = CascadeType.ALL)
    private List<HojaDespacho> hojasDespacho;
}
