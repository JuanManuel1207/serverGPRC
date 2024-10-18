package com.uptc.servicioMilitar.repositories;

import com.uptc.servicioMilitar.entities.Compania;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniaRepository extends JpaRepository<Compania,Long> {


}
