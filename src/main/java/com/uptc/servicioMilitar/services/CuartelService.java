package com.uptc.servicioMilitar.services;

import com.uptc.servicioMilitar.entities.Cuartel;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CuartelService {
    CompletableFuture<Cuartel> save(Cuartel school);
    CompletableFuture<Cuartel> getOneById(Long id);
    CompletableFuture<List<Cuartel>> getAll();
    CompletableFuture<Cuartel> update(Cuartel school, Long id);
    CompletableFuture<Cuartel> delete(Long id);
}
