package com.uptc.servicioMilitar.services;

import com.uptc.servicioMilitar.entities.Servicio;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ServicioService {
    CompletableFuture<Servicio> save(Servicio servicio);
    CompletableFuture<Servicio> getOneById(Long id);
    CompletableFuture<List<Servicio>> getAll();
    CompletableFuture<Servicio> update(Servicio servicio, Long id);
    CompletableFuture<Servicio> delete(Long id);
}
