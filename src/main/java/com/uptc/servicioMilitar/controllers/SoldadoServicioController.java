package com.uptc.servicioMilitar.controllers;

import com.uptc.servicioMilitar.entities.SoldadoServicio;
import com.uptc.servicioMilitar.services.SoldadoServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("servicioMilitar/v1/soldadoservicio")
public class SoldadoServicioController {
    @Autowired
    private SoldadoServicioService soldadoServicioService;

    @PostMapping("")
    public CompletableFuture<ResponseEntity> postRecord(@RequestBody SoldadoServicio soldadoServicio){
        return soldadoServicioService.save(soldadoServicio).thenApply(ResponseEntity::ok);
    }

    @GetMapping("")
    public CompletableFuture<ResponseEntity> getAll(){
        return soldadoServicioService.getAll().thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity> update(@RequestBody SoldadoServicio soldadoServici, @PathVariable Long id){
        return soldadoServicioService.update(soldadoServici,id).thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity> delete(@PathVariable Long id){
        return soldadoServicioService.delete(id).thenApply(ResponseEntity::ok);
    }
}
