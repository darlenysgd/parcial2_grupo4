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
    private long balance = 0;

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Transaccion> transacciones;
    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Tarjeta> tarjetas;
    @OneToMany (cascade = CascadeType.ALL)
    private List<IncrementoFondos> Fondos;

    public Cuenta() {
    }

    public Cuenta(long balance) {
        this.balance = balance;
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

    public List<IncrementoFondos> getFondos() {
        return Fondos;
    }

    public void setFondos(List<IncrementoFondos> fondos) {
        Fondos = fondos;
    }
}
