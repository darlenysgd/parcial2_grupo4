package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by darle on 7/25/2017.
 */

@Entity
public class Geolocalizacion implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long codigo;
    private String latitud;
    private String longitud;

    public Geolocalizacion(String latitud, String longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }


    public Geolocalizacion() {
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}