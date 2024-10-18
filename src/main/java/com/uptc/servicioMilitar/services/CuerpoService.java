package com.uptc.servicioMilitar.services;

import com.uptc.servicioMilitar.entities.Cuerpo;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface CuerpoService {
    CompletableFuture<Cuerpo> save(Cuerpo Cuerpo);
    CompletableFuture<Cuerpo> getOneById(Long id);
    CompletableFuture<List<Cuerpo>> getAll();
    CompletableFuture<Cuerpo> update(Cuerpo Cuerpo, Long id);
    CompletableFuture<Cuerpo> delete(Long id);
}
