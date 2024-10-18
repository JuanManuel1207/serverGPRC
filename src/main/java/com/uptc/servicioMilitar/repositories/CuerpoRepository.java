package com.uptc.servicioMilitar.repositories;

import com.uptc.servicioMilitar.entities.Cuerpo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuerpoRepository extends JpaRepository<Cuerpo,Long> {


}
