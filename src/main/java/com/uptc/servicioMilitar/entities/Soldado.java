package com.uptc.servicioMilitar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "SOLDADO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Soldado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String grado;
    private Integer status;
/*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPANIA", nullable = false)
    private Compania compania;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUERPO")
    private Cuerpo cuerpo;
*/
}
