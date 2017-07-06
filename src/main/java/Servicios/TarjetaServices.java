package Servicios;

import Entidades.Tarjeta;

/**
 * Created by darle on 7/6/2017.
 */
public class TarjetaServices extends GestionDB<Tarjeta>{


    private static Servicios.TarjetaServices instancia;


    private TarjetaServices() {
        super(Tarjeta.class);
    }

    public static Servicios.TarjetaServices getInstancia() {
        if (instancia == null) {
            instancia = new Servicios.TarjetaServices();
        }
        return instancia;
    }

}
