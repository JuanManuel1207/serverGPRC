package com.uptc.servicioMilitar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "CUERPO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuerpo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String denominacion;
    private Integer status;

    /*
    @OneToMany(mappedBy = "cuerpo")
    private List<Soldado> soldados;
    */
}
