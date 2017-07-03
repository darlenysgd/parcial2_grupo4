package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by darle on 6/28/2017.
 */

@Entity
public class Tarjeta implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long numero;
    private short cvc;
    private String fechaVencimiento;

    public Tarjeta() {
    }

    public Tarjeta(short cvc, String fechaVencimiento) {
        this.cvc = cvc;
        this.fechaVencimiento = fechaVencimiento;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public short getCvc() {
        return cvc;
    }

    public void setCvc(short cvc) {
        this.cvc = cvc;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
