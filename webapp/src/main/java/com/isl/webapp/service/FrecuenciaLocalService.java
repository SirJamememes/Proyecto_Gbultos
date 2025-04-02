package com.isl.webapp.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.isl.webapp.entity.DiaSemana;
import com.isl.webapp.entity.FrecuenciaLocal;
import com.isl.webapp.repository.FrecuenciaLocalRepository;
import com.isl.webapp.dto.FrecuenciaPorLocalDTO;
import com.isl.webapp.dto.LocalPorDiaDTO;

@Service
public class FrecuenciaLocalService {

    private final FrecuenciaLocalRepository repository;

    public FrecuenciaLocalService(FrecuenciaLocalRepository repository) {
        this.repository = repository;
    }

    public List<FrecuenciaLocal> obtenerPorLocal(String codigoLocal) {
        return repository.findByLocal_Codigo(codigoLocal);
    }

    public List<FrecuenciaLocal> obtenerPorDia(DiaSemana dia) {
        return repository.findByDia(dia);
    }

    public List<FrecuenciaPorLocalDTO> obtenerDiasDTO(String codigoLocal) {
        return repository.findByLocal_Codigo(codigoLocal).stream()
            .map(f -> new FrecuenciaPorLocalDTO(f.getLocal().getCodigo(), f.getDia()))
            .toList();
    }

    public List<LocalPorDiaDTO> obtenerLocalesPorDiaDTO(DiaSemana dia) {
        return repository.findByDia(dia).stream()
            .map(f -> {
                var local = f.getLocal();
                return new LocalPorDiaDTO(
                    local.getCodigo(),
                    local.getNombre(),
                    local.getZona(),
                    local.getDireccion() // 👈 agregar la dirección
                );
            })
            .distinct()
            .toList();
    } 
}
