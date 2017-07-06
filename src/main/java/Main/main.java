package Main; /**
 * Created by darle on 6/26/2017.
 */

import Entidades.Usuario;
import Servicios.BootStrapService;
import Servicios.UsuarioServices;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class main {
    private static int[] paleJugados = new int[3];
    private static int[] paleGanadores = new int[3];
    private static int[] lotoJugados = new int[5];
    private static int[] lotoGanadores = new int[5];
    private static boolean ganador;

    public static void main(String[] args) {

        staticFiles.location("/");
        enableDebugScreen();
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(main.class, "/Templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);


        BootStrapService.getInstancia().init();

        get("/Inicio", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes,"Home.ftl");

        }, freeMarkerEngine);

        get("/InicioSesion", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes,"Login.ftl");

        }, freeMarkerEngine);

        get("/NuevoUsuario", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes,"Registro.ftl");

        }, freeMarkerEngine);

        get("/AgregarFondos", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes,"AgregarFondos.ftl");

        }, freeMarkerEngine);

        post("/CrearUsuario", (request, response) -> {

            Usuario usuario = new Usuario();
            usuario.setUsuario(request.queryParams("usuario"));

            if(UsuarioServices.getInstancia().find(usuario.getUsuario())==null){

                usuario.setCedula(request.queryParams("cedula"));
                usuario.setNombre(request.queryParams("nombre"));
                usuario.setClave(request.queryParams("clave"));
                usuario.setFechaNacimiento(request.queryParams("fechanac"));
                UsuarioServices.getInstancia().crear(usuario);
            }
            else {
                response.redirect("/Inicio");
            }



            Map<String, Object> attributes = new HashMap<>();

            return new ModelAndView(attributes, "Home.ftl");
        },freeMarkerEngine);

        post("/LoginForm", (request, response) -> {

            String usuario = request.queryParams("usuario");
            String clave = request.queryParams("clave");

            if(UsuarioServices.getInstancia().find(usuario)!=null){
                Usuario userAux = UsuarioServices.getInstancia().find(usuario);
                if(userAux.getClave().equals(clave)){
                    request.session().attribute("usuario", usuario);
                }
            }

            response.redirect("/Inicio");

            return null;
        },freeMarkerEngine);

        get("/Fondos", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes,"agregarFondos.ftl");

        }, freeMarkerEngine);

        get("/transferirFondos", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes,"transferirFondos.ftl");

        }, freeMarkerEngine);

        get("/Transacciones", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes,"transacciones.ftl");

        }, freeMarkerEngine);

        get("/Pale", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();

            return new ModelAndView(attributes,"pale.ftl");


        }, freeMarkerEngine);

        post("/Pale", (request, response) -> {

        Map<String, Object> attributes = new HashMap<>();
        int cont = 0;
        int Primero = Integer.parseInt(request.queryParams("primerNumero"));
        int Segundo = Integer.parseInt(request.queryParams("segundoNumero"));
        int Tercero = Integer.parseInt(request.queryParams("tercerNumero"));

        paleJugados[0] = Primero;
        paleJugados[1] = Segundo;
        paleJugados[2] = Tercero;

        for (int i = 0; i < 3; i++){
            paleGanadores[i] = (int) (Math.random() * 12) + 1;
        }


        for (int j = 0; j< 3 ; j++){

            if(paleGanadores[j] == paleJugados[0]){
                ganador = true;
            }

        }
        response.redirect("/resultadoPale");
            return null;
        }, freeMarkerEngine);

        get("/resultadoPale", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("jugados", paleJugados);
            attributes.put("ganadores", paleGanadores);
            attributes.put("ganador", ganador);
            return new ModelAndView(attributes,"resultadoPale.ftl");

        }, freeMarkerEngine);

        get("/Loto", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes,"loto.ftl");

        }, freeMarkerEngine);

        post("/Loto", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();

            int cont = 0;
            int Primero = Integer.parseInt(request.queryParams("primerNumero"));
            int Segundo = Integer.parseInt(request.queryParams("segundoNumero"));
            int Tercero = Integer.parseInt(request.queryParams("tercerNumero"));
            int Cuarto = Integer.parseInt(request.queryParams("cuartoNumero"));
            int Quinto = Integer.parseInt(request.queryParams("quintoNumero"));

            lotoJugados[0] = Primero;
            lotoJugados[1] = Segundo;
            lotoJugados[2] = Tercero;
            lotoJugados[3] = Cuarto;
            lotoJugados[4] = Quinto;

            for (int i = 0; i < 5; i++){
                lotoGanadores[i] = (int) (Math.random() * 20) + 1;
            }


            for (int j = 0; j< 5 ; j++){

                if(lotoGanadores[j] == lotoJugados[0]){
                    ganador = true;
                }

            }
            response.redirect("/resultadoLoto");
            return null;

        }, freeMarkerEngine);
        get("/resultadoLoto", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            ganador = true;
            attributes.put("ganadores", lotoGanadores);
            attributes.put("jugados", lotoJugados);
            attributes.put("ganador", ganador);
            return new ModelAndView(attributes,"resultadoLoto.ftl");

        }, freeMarkerEngine);


    }
}
