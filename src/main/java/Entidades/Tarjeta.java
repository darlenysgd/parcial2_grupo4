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
    private long id;
    private String numero;
    private short cvc;
    private String mesVencimiento;
    private String yearVencimiento;

    public Tarjeta() {
    }

    public Tarjeta(short cvc, String mesVencimiento, String yearVencimiento) {
        this.cvc = cvc;
        this.mesVencimiento = mesVencimiento;
        this.yearVencimiento = yearVencimiento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String  numero) {
        this.numero = numero;
    }

    public short getCvc() {
        return cvc;
    }

    public void setCvc(short cvc) {
        this.cvc = cvc;
    }

    public String getMesVencimiento() {
        return mesVencimiento;
    }

    public void setMesVencimiento(String mesVencimiento) {
        this.mesVencimiento = mesVencimiento;
    }

    public String getYearVencimiento() {
        return yearVencimiento;
    }

    public void setYearVencimiento(String yearVencimiento) {
        this.yearVencimiento = yearVencimiento;
    }
}
