package com.uptc.servicioMilitar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SOLDADOSERVICIO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoldadoServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long soldado;
    private Long servicio;
    private Date fecha;
    private Integer status;
}
