package com.uptc.servicioMilitar.servicesImpl;

import com.uptc.servicioMilitar.entities.SoldadoServicio;
import com.uptc.servicioMilitar.repositories.SoldadoServicioRepository;
import com.uptc.servicioMilitar.services.SoldadoServicioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class SoldadoServicioServiceImpl implements SoldadoServicioService {
    @Autowired
    private SoldadoServicioRepository soldadoServicioRepository;

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<SoldadoServicio> save(SoldadoServicio soldadoServicio) {
        soldadoServicio.setStatus(1);
        return CompletableFuture.completedFuture(soldadoServicioRepository.save(soldadoServicio));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<SoldadoServicio> getOneById(Long id) {
        Optional<SoldadoServicio> school = soldadoServicioRepository.findById(id);
        return CompletableFuture.completedFuture(school.orElse(null));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<List<SoldadoServicio>> getAll() {
        return CompletableFuture.completedFuture(soldadoServicioRepository.findAll());
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<SoldadoServicio> update(SoldadoServicio school, Long id) {
        SoldadoServicio findStudent = soldadoServicioRepository.getById(id);
        if(findStudent.getId() != null){
            ModelMapper modelMapper = new ModelMapper();
            SoldadoServicio updateStudent = modelMapper.map(findStudent, SoldadoServicio.class);
            return CompletableFuture.completedFuture(soldadoServicioRepository.save(updateStudent));
        }else {
            return null;
        }
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<SoldadoServicio> delete(Long id) {
        SoldadoServicio findStudent = soldadoServicioRepository.getById(id);
        if(findStudent.getId() != null){
            findStudent.setStatus(0);
            return CompletableFuture.completedFuture(soldadoServicioRepository.save(findStudent));
        }else {
            return null;
        }
    }
}
