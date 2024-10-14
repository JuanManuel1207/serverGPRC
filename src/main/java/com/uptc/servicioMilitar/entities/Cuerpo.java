package com.uptc.servicioMilitar.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CUERPO")
public class Cuerpo {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "DENOMINACION")
    private String denominacion;

    @OneToMany(mappedBy = "cuerpo")
    private List<Soldado> soldados;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @Override
    public String toString() {
        return "Cuerpo{" +
                "id=" + id +
                ", denominacion='" + denominacion + '\'' +
                ", soldados=" + soldados +
                '}';
    }
}
