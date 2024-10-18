package com.uptc.servicioMilitar.servicesImpl;

import com.uptc.servicioMilitar.entities.Cuartel;
import com.uptc.servicioMilitar.repositories.CuartelRepository;
import com.uptc.servicioMilitar.services.CuartelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CuartelServiceImpl implements CuartelService {
    @Autowired
    private CuartelRepository schoolsRepository;

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Cuartel> save(Cuartel school) {
        school.setStatus(1);
        return CompletableFuture.completedFuture(schoolsRepository.save(school));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Cuartel> getOneById(Long id) {
        Optional<Cuartel> school = schoolsRepository.findById(id);
        return CompletableFuture.completedFuture(school.orElse(null));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<List<Cuartel>> getAll() {
        return CompletableFuture.completedFuture(schoolsRepository.findAll());
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Cuartel> update(Cuartel school, Long id) {
        Cuartel findStudent = schoolsRepository.getById(id);
        if(findStudent.getId() != null){
            ModelMapper modelMapper = new ModelMapper();
            Cuartel updateStudent = modelMapper.map(findStudent, Cuartel.class);
            return CompletableFuture.completedFuture(schoolsRepository.save(updateStudent));
        }else {
            return null;
        }
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Cuartel> delete(Long id) {
        Cuartel findStudent = schoolsRepository.getById(id);
        if(findStudent.getId() != null){
            findStudent.setStatus(0);
            return CompletableFuture.completedFuture(schoolsRepository.save(findStudent));
        }else {
            return null;
        }
    }
}
