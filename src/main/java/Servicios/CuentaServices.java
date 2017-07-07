package Servicios;

import Entidades.Cuenta;
import Entidades.IncrementoFondos;
import Entidades.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by darle on 7/6/2017.
 */
public class CuentaServices extends GestionDB<Cuenta>{

    private static Servicios.CuentaServices instancia;


    private CuentaServices() {
        super(Cuenta.class);
    }

    public static Servicios.CuentaServices getInstancia() {
        if (instancia == null) {
            instancia = new Servicios.CuentaServices();
        }
        return instancia;
    }


    /**
     *
     * @param username
     * @return
     */


    public Cuenta findbyusername(String username){

        EntityManager em = getEntityManager();
        Query query = em.createQuery("select e from Usuario e where e.usuario like :username");
        query.setParameter("username", username+"%");
        Usuario usuario = (Usuario)query.getSingleResult();

        return  usuario.getCuenta();
    }

}
