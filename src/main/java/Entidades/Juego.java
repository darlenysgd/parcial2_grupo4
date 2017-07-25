package Entidades;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by darle on 7/23/2017.
 */

@Entity
public class Juego implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long codigo;
    private String fecha;
    private boolean pale;
    private Boolean ganador;
    private Long montoGanado;
    private Long montoApostado;




    public Juego(String fecha, boolean pale, Boolean ganador, Long montoGanado, Long montoApostado) {
        this.fecha = fecha;
        this.pale = pale;
        this.ganador = ganador;
        this.montoGanado = montoGanado;
        this.montoApostado = montoApostado;

    }

    public Juego() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isPale() {
        return pale;
    }

    public void setPale(boolean pale) {
        this.pale = pale;
    }

    public Boolean getGanador() {
        return ganador;
    }

    public void setGanador(Boolean ganador) {
        this.ganador = ganador;
    }

    public Long getMontoGanado() {
        return montoGanado;
    }

    public void setMontoGanado(Long montoGanado) {
        this.montoGanado = montoGanado;
    }

    public Long getMontoApostado() {
        return montoApostado;
    }

    public void setMontoApostado(Long montoApostado) {
        this.montoApostado = montoApostado;
    }

}
