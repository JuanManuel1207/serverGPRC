package com.uptc.servicioMilitar.servicesImpl;

import com.uptc.servicioMilitar.entities.Cuerpo;
import com.uptc.servicioMilitar.repositories.CuerpoRepository;
import com.uptc.servicioMilitar.services.CuerpoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CuerpoServiceImpl implements CuerpoService {
    @Autowired
    private CuerpoRepository schoolsRepository;

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Cuerpo> save(Cuerpo school) {
        school.setStatus(1);
        return CompletableFuture.completedFuture(schoolsRepository.save(school));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Cuerpo> getOneById(Long id) {
        Optional<Cuerpo> school = schoolsRepository.findById(id);
        return CompletableFuture.completedFuture(school.orElse(null));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<List<Cuerpo>> getAll() {
        return CompletableFuture.completedFuture(schoolsRepository.findAll());
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Cuerpo> update(Cuerpo school, Long id) {
        Cuerpo findStudent = schoolsRepository.getById(id);
        if(findStudent.getId() != null){
            ModelMapper modelMapper = new ModelMapper();
            Cuerpo updateStudent = modelMapper.map(findStudent, Cuerpo.class);
            return CompletableFuture.completedFuture(schoolsRepository.save(updateStudent));
        }else {
            return null;
        }
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Cuerpo> delete(Long id) {
        Cuerpo findStudent = schoolsRepository.getById(id);
        if(findStudent.getId() != null){
            findStudent.setStatus(0);
            return CompletableFuture.completedFuture(schoolsRepository.save(findStudent));
        }else {
            return null;
        }
    }
}
