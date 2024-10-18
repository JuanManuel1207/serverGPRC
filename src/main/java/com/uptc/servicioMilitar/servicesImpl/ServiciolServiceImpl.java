package com.uptc.servicioMilitar.servicesImpl;

import com.uptc.servicioMilitar.entities.Servicio;
import com.uptc.servicioMilitar.repositories.ServicioRepository;
import com.uptc.servicioMilitar.services.ServicioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class ServiciolServiceImpl implements ServicioService {
    @Autowired
    private ServicioRepository servicioRepository;

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Servicio> save(Servicio school) {
        school.setStatus(1);
        return CompletableFuture.completedFuture(servicioRepository.save(school));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Servicio> getOneById(Long id) {
        Optional<Servicio> school = servicioRepository.findById(id);
        return CompletableFuture.completedFuture(school.orElse(null));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<List<Servicio>> getAll() {
        return CompletableFuture.completedFuture(servicioRepository.findAll());
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Servicio> update(Servicio school, Long id) {
        Servicio findStudent = servicioRepository.getById(id);
        if(findStudent.getId() != null){
            ModelMapper modelMapper = new ModelMapper();
            Servicio updateStudent = modelMapper.map(findStudent, Servicio.class);
            return CompletableFuture.completedFuture(servicioRepository.save(updateStudent));
        }else {
            return null;
        }
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Servicio> delete(Long id) {
        Servicio findStudent = servicioRepository.getById(id);
        if(findStudent.getId() != null){
            findStudent.setStatus(0);
            return CompletableFuture.completedFuture(servicioRepository.save(findStudent));
        }else {
            return null;
        }
    }
}
