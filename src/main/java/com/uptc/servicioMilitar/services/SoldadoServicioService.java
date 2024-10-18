package com.uptc.servicioMilitar.services;

import com.uptc.servicioMilitar.entities.SoldadoServicio;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface SoldadoServicioService {
    CompletableFuture<SoldadoServicio> save(SoldadoServicio soldadoServicio);
    CompletableFuture<SoldadoServicio> getOneById(Long id);
    CompletableFuture<List<SoldadoServicio>> getAll();
    CompletableFuture<SoldadoServicio> update(SoldadoServicio soldadoServicio, Long id);
    CompletableFuture<SoldadoServicio> delete(Long id);
}
