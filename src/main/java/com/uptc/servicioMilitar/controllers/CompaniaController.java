package com.uptc.servicioMilitar.controllers;

import com.uptc.servicioMilitar.entities.Compania;
import com.uptc.servicioMilitar.services.CompaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("servicioMilitar/v1/compania")
public class CompaniaController {
    @Autowired
    private CompaniaService companiaService;

    @PostMapping("")
    public CompletableFuture<ResponseEntity> postRecord(@RequestBody Compania compania){
        return companiaService.save(compania).thenApply(ResponseEntity::ok);
    }

    @GetMapping("")
    public CompletableFuture<ResponseEntity> getAll(){
        return companiaService.getAll().thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity> update(@RequestBody Compania compania, @PathVariable Long id){
        return companiaService.update(compania,id).thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity> delete(@PathVariable Long id){
        return companiaService.delete(id).thenApply(ResponseEntity::ok);
    }
}
