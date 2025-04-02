package com.isl.webapp.controller;

import com.isl.webapp.entity.ControlDespacho;
import com.isl.webapp.service.ControlDespachoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controles")
public class ControlDespachoController {

    private final ControlDespachoService service;

    public ControlDespachoController(ControlDespachoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ControlDespacho> listar() {
        return service.obtenerTodos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ControlDespacho> obtener(@PathVariable String codigo) {
        return service.buscarPorId(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ControlDespacho crear(@RequestBody ControlDespacho control) {
        return service.guardar(control);
    }

    @DeleteMapping("/{codigo}")
    public void eliminar(@PathVariable String codigo) {
        service.eliminar(codigo);
    }
}
