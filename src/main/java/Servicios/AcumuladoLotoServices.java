package Servicios;

import Entidades.AcumuladoLoto;
import Entidades.Cuenta;
import Entidades.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


/**
 * Created by darle on 7/7/2017.
 */
public class AcumuladoLotoServices extends GestionDB<AcumuladoLoto> {


    private static Servicios.AcumuladoLotoServices instancia;


    private AcumuladoLotoServices() {
        super(AcumuladoLoto.class);
    }

    public static Servicios.AcumuladoLotoServices getInstancia() {
        if (instancia == null) {
            instancia = new Servicios.AcumuladoLotoServices();
        }
        return instancia;
    }

    /**
     *
     *
     * @return
     */


    public AcumuladoLoto cargarAcumulado(){

        EntityManager em = getEntityManager();
        Query query = em.createQuery("from AcumuladoLoto ");
        query.setMaxResults(1);
        List<AcumuladoLoto> acumuladoLoto = query.getResultList();

        acumuladoLoto.get(0).setAcumulado(acumuladoLoto.get(0).getAcumulado());
        AcumuladoLoto loto = acumuladoLoto.get(0);
        return  loto;
    }

}
