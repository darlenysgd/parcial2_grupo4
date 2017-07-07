package Servicios;

import Entidades.Cuenta;
import Entidades.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by darle on 6/29/2017.
 */
public class UsuarioServices extends GestionDB<Usuario>{

    private static UsuarioServices instancia;


    private UsuarioServices() {
        super(Usuario.class);
    }

    public static UsuarioServices getInstancia() {
        if (instancia == null) {
            instancia = new UsuarioServices();
        }
        return instancia;
    }








}
