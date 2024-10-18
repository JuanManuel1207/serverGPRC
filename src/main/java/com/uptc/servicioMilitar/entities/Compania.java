package com.uptc.servicioMilitar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "COMPANIA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numeroCompania;
    private String actividad;

    @ManyToOne
    @JoinColumn(name = "cuartelId",nullable = false)
    private Cuartel cuartel;

    /*
    @OneToMany(mappedBy = "compania")
    private List<Soldado> soldados;
    */
}
