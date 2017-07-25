package Servicios;

import Entidades.Juego;
import Entidades.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darle on 7/23/2017.
 */
public class JuegosServices {

    private static JuegosServices instancia;

    public static JuegosServices getInstancia(){
        if(instancia==null){
            instancia = new JuegosServices();
        }
        return instancia;
    }

    /**
     * Consulta el estudiante dado la matricula
     * @param usuario
     * @return
     */
    public List<Juego> juegos(String usuario){

        Usuario usr = UsuarioServices.getInstancia().find(usuario);

        return usr.getJuegos();
    }



}
