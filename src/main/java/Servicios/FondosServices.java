package Servicios;

import Entidades.IncrementoFondos;
import Entidades.Tarjeta;

/**
 * Created by darle on 7/6/2017.
 */
public class FondosServices extends GestionDB<IncrementoFondos> {

    private static Servicios.FondosServices instancia;


    private FondosServices() {
        super(IncrementoFondos.class);
    }

    public static Servicios.FondosServices getInstancia() {
        if (instancia == null) {
            instancia = new Servicios.FondosServices();
        }
        return instancia;
    }

}
