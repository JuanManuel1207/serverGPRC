package com.uptc.servicioMilitar.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SOLDADO_SERVICIO")
public class SoldadoServicio implements Serializable {

    @EmbeddedId
    private SoldadoServicioId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idSoldado")
    @JoinColumn(name = "ID_SOLDADO", nullable = false)
    private Soldado soldado;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idServicio")
    @JoinColumn(name = "ID_SERVICIO", nullable = false)
    private Servicio servicio;

    @Column(name = "FECHA", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public SoldadoServicioId getId() {
        return id;
    }

    public void setId(SoldadoServicioId id) {
        this.id = id;
    }

    public Soldado getSoldado() {
        return soldado;
    }

    public void setSoldado(Soldado soldado) {
        this.soldado = soldado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "SoldadoServicio{" +
                "id=" + id +
                ", fecha=" + fecha +
                '}';
    }
}
