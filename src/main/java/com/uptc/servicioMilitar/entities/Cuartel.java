package com.uptc.servicioMilitar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUARTEL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cuartel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ubicacion;
    private Integer status;

    @OneToMany(mappedBy = "cuartel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Compania> companias;
}