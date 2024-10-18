package com.uptc.servicioMilitar.controllers;

import com.uptc.servicioMilitar.entities.Soldado;
import com.uptc.servicioMilitar.services.SoldadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("servicioMilitar/v1/soldado")
public class SoldadoController {
    @Autowired
    private SoldadoService soldadoServicio;

    @PostMapping("")
    public CompletableFuture<ResponseEntity> postRecord(@RequestBody Soldado soldado){
        return soldadoServicio.save(soldado).thenApply(ResponseEntity::ok);
    }

    @GetMapping("")
    public CompletableFuture<ResponseEntity> getAll(){
        return soldadoServicio.getAll().thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity> update(@RequestBody Soldado soldado, @PathVariable Long id){
        return soldadoServicio.update(soldado,id).thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity> delete(@PathVariable Long id){
        return soldadoServicio.delete(id).thenApply(ResponseEntity::ok);
    }
}
