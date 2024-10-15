package com.uptc.servicioMilitar.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SoldadoServicioId implements Serializable {

    @Column(name = "ID_SOLDADO")
    private Long idSoldado;

    @Column(name = "ID_SERVICIO")
    private Long idServicio;

    public SoldadoServicioId() {}

    public SoldadoServicioId(Long idSoldado, Long idServicio) {
        this.idSoldado = idSoldado;
        this.idServicio = idServicio;
    }

    public Long getIdSoldado() {
        return idSoldado;
    }

    public void setIdSoldado(Long idSoldado) {
        this.idSoldado = idSoldado;
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SoldadoServicioId that = (SoldadoServicioId) o;
        return Objects.equals(idSoldado, that.idSoldado) &&
                Objects.equals(idServicio, that.idServicio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSoldado, idServicio);
    }
}
