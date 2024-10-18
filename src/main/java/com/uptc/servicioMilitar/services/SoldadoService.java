package com.uptc.servicioMilitar.services;

import com.uptc.servicioMilitar.entities.Soldado;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface SoldadoService {
    CompletableFuture<Soldado> save(Soldado soldado);
    CompletableFuture<Soldado> getOneById(Long id);
    CompletableFuture<List<Soldado>> getAll();
    CompletableFuture<Soldado> update(Soldado soldado, Long id);
    CompletableFuture<Soldado> delete(Long id);
}
