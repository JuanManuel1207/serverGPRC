package com.uptc.servicioMilitar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SERVICIO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private Integer status;
/*
    @OneToMany(mappedBy = "servicio")
    private List<SoldadoServicio> soldadoServicios;
*/


}
