package Servicios;

import Entidades.Transaccion;
import Entidades.Usuario;

/**
 * Created by darle on 7/6/2017.
 */
public class TransaccionServices extends GestionDB<Transaccion>{

    private static TransaccionServices instancia;


    private TransaccionServices() {
        super(Transaccion.class);
    }

    public static TransaccionServices getInstancia() {
        if (instancia == null) {
            instancia = new TransaccionServices();
        }
        return instancia;
    }
}
