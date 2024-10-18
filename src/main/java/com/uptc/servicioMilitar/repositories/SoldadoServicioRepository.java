package com.uptc.servicioMilitar.repositories;

import com.uptc.servicioMilitar.entities.SoldadoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoldadoServicioRepository extends JpaRepository<SoldadoServicio,Long> {


}
