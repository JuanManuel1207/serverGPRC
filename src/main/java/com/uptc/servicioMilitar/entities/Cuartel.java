package com.uptc.servicioMilitar.entities;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "CUARTEL")
public class Cuartel {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "UBICACION")
    private String ubicacion;

    @OneToMany(mappedBy = "cuartel")
    private List<Compania> companias;

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Compania> getCompanias() {
        return companias;
    }

    public void setCompanias(List<Compania> companias) {
        this.companias = companias;
    }

    @Override
    public String toString() {
        return "Cuartel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                '}';
    }
}
