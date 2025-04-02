package com.isl.webapp.dto;

import com.isl.webapp.entity.DiaSemana;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class FrecuenciaPorLocalDTO {
    private String codigoLocal;
    private DiaSemana dia;
}