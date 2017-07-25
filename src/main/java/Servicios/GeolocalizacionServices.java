package Servicios;

import Entidades.Geolocalizacion;



/**
 * Created by darle on 7/25/2017.
 */
public class GeolocalizacionServices extends GestionDB<Geolocalizacion> {

    private static Servicios.GeolocalizacionServices instancia;


    private GeolocalizacionServices() {
        super(Geolocalizacion.class);
    }

    public static Servicios.GeolocalizacionServices getInstancia() {
        if (instancia == null) {
            instancia = new Servicios.GeolocalizacionServices();
        }
        return instancia;
    }

    /**
     *
     *
     * @return
     */




}
