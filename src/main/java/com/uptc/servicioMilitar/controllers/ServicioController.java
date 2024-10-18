package com.uptc.servicioMilitar.controllers;

import com.uptc.servicioMilitar.entities.Servicio;
import com.uptc.servicioMilitar.services.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("servicioMilitar/v1/servicio")
public class ServicioController {
    @Autowired
    private ServicioService servicioService;

    @PostMapping("")
    public CompletableFuture<ResponseEntity> postRecord(@RequestBody Servicio school){
        return servicioService.save(school).thenApply(ResponseEntity::ok);
    }

    @GetMapping("")
    public CompletableFuture<ResponseEntity> getAll(){
        return servicioService.getAll().thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity> update(@RequestBody Servicio school, @PathVariable Long id){
        return servicioService.update(school,id).thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity> delete(@PathVariable Long id){
        return servicioService.delete(id).thenApply(ResponseEntity::ok);
    }
}
