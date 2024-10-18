package com.uptc.servicioMilitar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "COMPANIA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Compania {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numeroCompania;
    private String actividad;
    private Integer status;
    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUARTEL")
    private Cuartel cuartel;

    @OneToMany(mappedBy = "compania")
    private List<Soldado> soldados;
*/
}