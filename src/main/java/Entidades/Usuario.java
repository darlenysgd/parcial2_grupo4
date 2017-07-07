package Entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by darle on 6/28/2017.
 */

@Entity
public class Usuario implements Serializable {

    @Id
    private String usuario;
    private String cedula;
    private String nombre;
    private String clave;
    private boolean adminsitrador; //CORREGIR NOMBRE
    private String fechaNacimiento;
    @OneToOne ( cascade = CascadeType.MERGE)
    private Cuenta cuenta;

    public Usuario(String cedula, String nombre, String usuario, String clave, String fechaNacimiento) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
        this.adminsitrador = false;
    }

    public Usuario() {
    }


    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isAdminsitrador() {
        return adminsitrador;
    }

    public void setAdminsitrador(boolean adminsitrador) {
        this.adminsitrador = adminsitrador;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
