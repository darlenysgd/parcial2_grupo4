package Entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by darle on 6/28/2017.
 */

@Entity
public class Transaccion implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long codigo;
    @OneToOne
    private Usuario usuarioOrigen;
    @OneToOne
    private Usuario usuarioDestino;
    private long montoTransferido;
    private String fecha;

    public Transaccion(Usuario usuarioOrigen, Usuario usuarioDestino, long montoTransferido, String fecha) {
        this.usuarioOrigen = usuarioOrigen;
        this.usuarioDestino = usuarioDestino;
        this.montoTransferido = montoTransferido;
        this.fecha = fecha;
    }

    public Transaccion() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuarioOrigen() {
        return usuarioOrigen;
    }

    public void setUsuarioOrigen(Usuario usuarioOrigen) {
        this.usuarioOrigen = usuarioOrigen;
    }

    public Usuario getUsuarioDestino() {
        return usuarioDestino;
    }

    public void setUsuarioDestino(Usuario usuarioDestino) {
        this.usuarioDestino = usuarioDestino;
    }

    public long getMontoTransferido() {
        return montoTransferido;
    }

    public void setMontoTransferido(long montoTransferido) {
        this.montoTransferido = montoTransferido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
