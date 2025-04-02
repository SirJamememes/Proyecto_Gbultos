package com.isl.webapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isl.webapp.dto.FrecuenciaPorLocalDTO;
import com.isl.webapp.entity.DiaSemana;
import com.isl.webapp.service.FrecuenciaLocalService;
import com.isl.webapp.dto.LocalPorDiaDTO;

@RestController
@RequestMapping("/api/frecuencia")
public class FrecuenciaLocalController {

    private final FrecuenciaLocalService service;

    public FrecuenciaLocalController(FrecuenciaLocalService service) {
        this.service = service;
    }

    // Obtener días que puede recibir un local
    @GetMapping("/local/{codigoLocal}")
    public List<FrecuenciaPorLocalDTO> obtenerDiasPorLocal(@PathVariable String codigoLocal) {
        return service.obtenerDiasDTO(codigoLocal);
    }

    // Obtener locales que pueden recibir en un día
    @GetMapping("/dia/{dia}")
    public List<LocalPorDiaDTO> obtenerLocalesPorDia(@PathVariable String dia) {
        DiaSemana diaEnum = DiaSemana.valueOf(dia.toUpperCase());
        return service.obtenerLocalesPorDiaDTO(diaEnum);
    }
}
