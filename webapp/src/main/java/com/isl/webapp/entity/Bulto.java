package com.isl.webapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bultos")
@Data
public class Bulto {

    @Id
    @Column(length = 15)
    private String idBulto;

    @ManyToOne
    @JoinColumn(name = "id_hoja", nullable = false)
    private HojaDespacho hojaDespacho;

    @Column(length = 20, nullable = false)
    private String tipoBulto;  // "caja" o "bandeja"

    @Column(length = 20)
    private String estadoEntrega;  // "recepcionado", "faltante", "sobrante" (puede ser null al inicio)
}
