package com.isl.webapp.service;

import com.isl.webapp.entity.ControlDespacho;
import com.isl.webapp.repository.ControlDespachoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ControlDespachoService {

    private final ControlDespachoRepository repository;

    public ControlDespachoService(ControlDespachoRepository repository) {
        this.repository = repository;
    }

    public List<ControlDespacho> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<ControlDespacho> buscarPorId(String codigo) {
        return repository.findById(codigo);
    }

    public ControlDespacho guardar(ControlDespacho control) {
        return repository.save(control);
    }

    public void eliminar(String codigo) {
        repository.deleteById(codigo);
    }
}
