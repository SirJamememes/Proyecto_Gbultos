package com.isl.webapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LocalPorDiaDTO {
    private String codigo;
    private String nombre;
    private String zona;
    private String direccion; 
}
