package Servicios;

import Entidades.Ganador;

/**
 * Created by darle on 7/4/2017.
 */
public class GanadorServices extends GestionDB<Ganador>{


        private static Servicios.GanadorServices instancia;


        private GanadorServices() {
            super(Ganador.class);
        }

        public static Servicios.GanadorServices getInstancia() {
            if (instancia == null) {
                instancia = new Servicios.GanadorServices();
            }
            return instancia;
        }




}
