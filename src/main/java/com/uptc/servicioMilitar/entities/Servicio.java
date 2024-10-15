package com.uptc.servicioMilitar.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SERVICIO")
public class Servicio {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    private String descripcion;

    @OneToMany(mappedBy = "servicio")
    private List<SoldadoServicio> soldadoServicios;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<SoldadoServicio> getSoldadoServicios() {
        return soldadoServicios;
    }

    public void setSoldadoServicios(List<SoldadoServicio> soldadoServicios) {
        this.soldadoServicios = soldadoServicios;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
