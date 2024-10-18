package com.uptc.servicioMilitar.repositories;

import com.uptc.servicioMilitar.entities.Cuartel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuartelRepository extends JpaRepository<Cuartel,Long> {


}
