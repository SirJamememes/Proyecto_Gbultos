package com.isl.webapp.controller;

import com.isl.webapp.entity.Local;
import com.isl.webapp.service.LocalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.isl.webapp.dto.UpdateNombreAlternativoDTO;

import java.util.List;

@RestController
@RequestMapping("/api/locales")
public class LocalController {

    private final LocalService service;

    public LocalController(LocalService service) {
        this.service = service;
    }

    // Listar todos
    @GetMapping
    public List<Local> listarLocales() {
        return service.listarTodos();
    }

    // Buscar por código
    @GetMapping("/{codigo}")
    public ResponseEntity<Local> obtenerLocal(@PathVariable String codigo) {
        return service.buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Modificar solo el nombre alternativo
    @PutMapping("/{codigo}")
    public ResponseEntity<Local> actualizarNombreAlternativo(@PathVariable String codigo,@RequestBody UpdateNombreAlternativoDTO dto) {
        return service.actualizarNombreAlternativo(codigo, dto.getNombreAlternativo()).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
}