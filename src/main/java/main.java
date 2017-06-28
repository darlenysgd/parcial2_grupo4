/**
 * Created by darle on 6/26/2017.
 */

import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class main {

    public static void main(String[] args) {

        staticFiles.location("/");
        enableDebugScreen();
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(main.class, "/Templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);


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

        get("/Fondos", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes,"ControldeFondos.ftl");

        }, freeMarkerEngine);

    }
}
