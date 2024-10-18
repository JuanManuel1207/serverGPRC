package com.uptc.servicioMilitar.servicesImpl;

import com.uptc.servicioMilitar.entities.Soldado;
import com.uptc.servicioMilitar.repositories.SoldadoRepository;
import com.uptc.servicioMilitar.services.SoldadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class SoldadoServiceImpl implements SoldadoService {
    @Autowired
    private SoldadoRepository soldadoRepository;

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Soldado> save(Soldado soldado) {
        soldado.setStatus(1);
        return CompletableFuture.completedFuture(soldadoRepository.save(soldado));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Soldado> getOneById(Long id) {
        Optional<Soldado> school = soldadoRepository.findById(id);
        return CompletableFuture.completedFuture(school.orElse(null));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<List<Soldado>> getAll() {
        return CompletableFuture.completedFuture(soldadoRepository.findAll());
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Soldado> update(Soldado soldado, Long id) {
        Soldado findStudent = soldadoRepository.getById(id);
        if(findStudent.getId() != null){
            ModelMapper modelMapper = new ModelMapper();
            Soldado updateStudent = modelMapper.map(findStudent, Soldado.class);
            return CompletableFuture.completedFuture(soldadoRepository.save(updateStudent));
        }else {
            return null;
        }
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Soldado> delete(Long id) {
        Soldado findStudent = soldadoRepository.getById(id);
        if(findStudent.getId() != null){
            findStudent.setStatus(0);
            return CompletableFuture.completedFuture(soldadoRepository.save(findStudent));
        }else {
            return null;
        }
    }
}
