package com.uptc.servicioMilitar.services;

import com.uptc.servicioMilitar.entities.Compania;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CompaniaService {
    CompletableFuture<Compania> save(Compania compania);
    CompletableFuture<Compania> getOneById(Long id);
    CompletableFuture<List<Compania>> getAll();
    CompletableFuture<Compania> update(Compania compania, Long id);
    CompletableFuture<Compania> delete(Long id);
}
