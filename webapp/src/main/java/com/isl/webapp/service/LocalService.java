package com.isl.webapp.service;

import com.isl.webapp.entity.Local;
import com.isl.webapp.repository.LocalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalService {

    private final LocalRepository repository;

    public LocalService(LocalRepository repository) {
        this.repository = repository;
    }

    public List<Local> listarTodos() {
        return repository.findAll();
    }

    public Local registrar(Local local) {
        return repository.save(local);
    }

    public Optional<Local> buscarPorCodigo(String codigo) {
        return repository.findById(codigo);
    }
    
    public Optional<Local> actualizarNombreAlternativo(String codigo, String nuevoNombreAlternativo) {
        return repository.findById(codigo).map(local -> {
            local.setNombreAlternativo(nuevoNombreAlternativo);
            return repository.save(local);
        });
    }
}