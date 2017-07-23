package Entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by darle on 7/7/2017.
 */

@Entity
public class AcumuladoLoto implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private long acumulado = 1000000;

    public AcumuladoLoto(long acumulado) {
        this.acumulado = acumulado;
    }

    public AcumuladoLoto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(long acumulado) {
        this.acumulado = acumulado;
    }
}
