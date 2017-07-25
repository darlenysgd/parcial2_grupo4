package Servicios;

import Entidades.Juego;
import Entidades.Tarjeta;

/**
 * Created by darle on 7/23/2017.
 */
public class JuegosServicesDB extends GestionDB<Juego>{

    private static Servicios.JuegosServicesDB instancia;


    private JuegosServicesDB() {
        super(Juego.class);
    }

    public static Servicios.JuegosServicesDB getInstancia() {
        if (instancia == null) {
            instancia = new Servicios.JuegosServicesDB();
        }
        return instancia;
    }

}
