package com.uptc.servicioMilitar.controllers;

import com.uptc.servicioMilitar.entities.Cuartel;
import com.uptc.servicioMilitar.services.CuartelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("servicioMilitar/v1/cuartel")
public class CuartelController {
    @Autowired
    private CuartelService schoolsService;

    @PostMapping("")
    public CompletableFuture<ResponseEntity> postRecord(@RequestBody Cuartel school){
        return schoolsService.save(school).thenApply(ResponseEntity::ok);
    }

    @GetMapping("")
    public CompletableFuture<ResponseEntity> getAll(){
        return schoolsService.getAll().thenApply(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public CompletableFuture<ResponseEntity> update(@RequestBody Cuartel school, @PathVariable Long id){
        return schoolsService.update(school,id).thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<ResponseEntity> delete(@PathVariable Long id){
        return schoolsService.delete(id).thenApply(ResponseEntity::ok);
    }
}
