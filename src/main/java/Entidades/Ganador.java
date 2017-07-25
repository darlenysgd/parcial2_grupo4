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
    @Column(length = 2000000)
    private byte[] imagen;
    private String mensaje;
    private String rutaImagen;
    @OneToOne
    private Geolocalizacion geolocalizacion;

    public Ganador() {
    }

    public Ganador(Usuario usuario, byte[] imagen, String mensaje) {
        this.usuario = usuario;
        this.imagen = imagen;
        this.mensaje = mensaje;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Geolocalizacion getGeolocalizacion() {
        return geolocalizacion;
    }

    public void setGeolocalizacion(Geolocalizacion geolocalizacion) {
        this.geolocalizacion = geolocalizacion;
    }
}
