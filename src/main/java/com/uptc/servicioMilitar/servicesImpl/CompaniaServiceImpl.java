package com.uptc.servicioMilitar.servicesImpl;

import com.uptc.servicioMilitar.entities.Compania;
import com.uptc.servicioMilitar.repositories.CompaniaRepository;
import com.uptc.servicioMilitar.services.CompaniaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CompaniaServiceImpl implements CompaniaService {
    @Autowired
    private CompaniaRepository companiaRepository;

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Compania> save(Compania compania) {
        compania.setStatus(1);
        return CompletableFuture.completedFuture(companiaRepository.save(compania));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Compania> getOneById(Long id) {
        Optional<Compania> compania = companiaRepository.findById(id);
        return CompletableFuture.completedFuture(compania.orElse(null));
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<List<Compania>> getAll() {
        return CompletableFuture.completedFuture(companiaRepository.findAll());
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Compania> update(Compania compania, Long id) {
        Compania findComp = companiaRepository.getById(id);
        if(findComp.getId() != null){
            ModelMapper modelMapper = new ModelMapper();
            Compania updateCompania = modelMapper.map(findComp, Compania.class);
            return CompletableFuture.completedFuture(companiaRepository.save(updateCompania));
        }else {
            return null;
        }
    }

    @Async("asyncExecutor")
    @Override
    public CompletableFuture<Compania> delete(Long id) {
        Compania findComp = companiaRepository.getById(id);
        if(findComp.getId() != null){
            findComp.setStatus(0);
            return CompletableFuture.completedFuture(companiaRepository.save(findComp));
        }else {
            return null;
        }
    }
}
