package Entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by darle on 7/6/2017.
 */

@Entity
public class IncrementoFondos implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long codigo;
    @OneToOne
    private Usuario usuario;
    private String fecha;
    private long monto;
    @OneToOne
    private Tarjeta tarjeta;


    public IncrementoFondos() {
    }

    public IncrementoFondos(Usuario usuario, String fecha, long monto, Tarjeta tarjeta) {
        this.usuario = usuario;
        this.fecha = fecha;
        this.monto = monto;
        this.tarjeta = tarjeta;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getMonto() {
        return monto;
    }

    public void setMonto(long monto) {
        this.monto = monto;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
