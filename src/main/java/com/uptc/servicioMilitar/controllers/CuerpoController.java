package com.uptc.servicioMilitar.controllers;

import com.uptc.servicioMilitar.entities.Cuerpo;
import com.uptc.servicioMilitar.services.CuerpoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("servicioMilitar/v1/cuerpo")
public class CuerpoController {
    @Autowired
    private CuerpoService schoolsService;

    @PostMapping("")
    public CompletableFuture<ResponseEntity> postRecord(@RequestBody Cuerpo school){
        return schoolsService.save(school).thenApply(ResponseEntity::ok);
    }

    @GetMapping("")
    public CompletableFuture<ResponseEntity> getAll(){
        return schoolsService.getAll().thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity> update(@RequestBody Cuerpo school, @PathVariable Long id){
        return schoolsService.update(school,id).thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity> delete(@PathVariable Long id){
        return schoolsService.delete(id).thenApply(ResponseEntity::ok);
    }
}
