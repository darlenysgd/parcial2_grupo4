package Main; /**
 * Created by darle on 6/26/2017.
 */

import Entidades.Usuario;
import Servicios.BootStrapService;
import Servicios.UsuarioServices;
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

    }
}
