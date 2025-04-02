package com.isl.webapp.repository;

import com.isl.webapp.entity.DiaSemana;
import com.isl.webapp.entity.FrecuenciaLocal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FrecuenciaLocalRepository extends JpaRepository<FrecuenciaLocal, Long> {

    List<FrecuenciaLocal> findByLocal_Codigo(String codigoLocal);
    
    List<FrecuenciaLocal> findByDia(DiaSemana dia);
}
