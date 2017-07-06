package Entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by darle on 6/28/2017.
 */

@Entity
public class Ganador implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long codigo;
    @OneToOne
    private Usuario usuario;
    @Column(length = 1000000)
    private byte[] imagen;

    public Ganador() {
    }

    public Ganador(Usuario usuario, byte[] imagen) {
        this.usuario = usuario;
        this.imagen = imagen;
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

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
