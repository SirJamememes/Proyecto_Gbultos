package com.isl.webapp.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "hoja_despacho")
@Data
public class HojaDespacho {

    @Id
    @Column(length = 17)  // 13 del control + 4 del local
    private String idHoja;

    @ManyToOne
    @JoinColumn(name = "codigo_control", nullable = false)
    private ControlDespacho controlDespacho;

    @Column(length = 4, nullable = false)
    private String codigoLocal;

    private int cantidadBultos;

    @OneToMany(mappedBy = "hojaDespacho", cascade = CascadeType.ALL)
    private List<Bulto> bultos;
}
