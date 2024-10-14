package com.uptc.servicioMilitar.entities;

import javax.persistence.*;

@Entity
@Table(name = "COMPANIA")
public class Compania {

    @Id
    @Column(name = "ID")
    private long id;
    @Column(name = "NUMEROCOMPANIA")
    private int numeroCompania;
    @Column(name = "ACTIVIDAD")
    private String actividad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUARTEL")
    private Cuartel cuartel;



    public void setId(long id) {
        this.id = id;
    }

    public int getNumeroCompania() {
        return numeroCompania;
    }

    public void setNumeroCompania(int numeroCompania) {
        this.numeroCompania = numeroCompania;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }



    @Override
    public String toString() {
        return "Compania{" +
                "id=" + id +
                ", numeroCompania=" + numeroCompania +
                ", actividad='" + actividad + '\'' +
                '}';
    }
}
