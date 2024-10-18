package com.uptc.servicioMilitar.entities;

import javax.persistence.*;
import java.util.List;

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

