package Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by darle on 6/28/2017.
 */

@Entity
public class Cuenta implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long codigo;
    private long balance;

    @OneToMany (fetch = FetchType.EAGER)
    private List<Transaccion> transacciones;
    @OneToMany (fetch = FetchType.EAGER)
    private List<Tarjeta> tarjetas;

    public Cuenta() {
    }

    public Cuenta(long balance, List<Transaccion> transacciones, List<Tarjeta> tarjetas) {
        this.balance = balance;
        this.transacciones = transacciones;
        this.tarjetas = tarjetas;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }
}
