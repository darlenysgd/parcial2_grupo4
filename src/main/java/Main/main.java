package Main; /**
 * Created by darle on 6/26/2017.
 */

import Entidades.*;
import Servicios.*;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import javax.servlet.MultipartConfigElement;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
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
    private static Usuario user1;
    private static SecureRandom number;


    public static File imageUpload = new File("./src/main/resources/img");
    static boolean loggeado = false;
    static boolean firstTime = false;
    static  Usuario userAux = null;
    public static void main(String[] args) {

        port(4567);

        staticFiles.location("/");
        staticFiles.externalLocation(System.getProperty("java.io.tmpdir"));

        enableDebugScreen();
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(main.class, "/Templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);


        BootStrapService.getInstancia().init();



        try {
            number = SecureRandom.getInstance("SHA1PRNG");
        } catch(NoSuchAlgorithmException nsae) {
            // Process the exception in some way or the other
        }


        get("/Inicio", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes,"Home.ftl");

        }, freeMarkerEngine);

        get("/InicioSesion", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes,"Login.ftl");

        }, freeMarkerEngine);

        get("/NuevoUsuario", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes,"Registro.ftl");

        }, freeMarkerEngine);


        before("/AgregarFondos", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null){
                response.redirect("/InicioSesion");
            }
        });

            get("/AgregarFondos", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            Usuario usuario= request.session().attribute("usuario");

            if(usuario.getCuenta().getTarjetas() != null) {
                List<Tarjeta> tarjetas = UsuarioServices.getInstancia().find(usuario.getUsuario()).getCuenta().getTarjetas();
                attributes.put("tarjetas", tarjetas);
            }else{
                List<Tarjeta> tarjAux = new ArrayList<>();
                attributes.put("tarjetas", tarjAux);
            }

            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes,"AgregarFondos.ftl");

        }, freeMarkerEngine);


     //   before("/transferirFondos", (request, response) -> {

       //     Usuario str = request.session().attribute("usuario");
         //   if (str == null){
           //     response.redirect("/InicioSesion");
           // }
        //});

        get("/transferirFondos", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();

            attributes.put("loggeado", loggeado);
            attributes.put("maxTransferencia", user1.getCuenta().getBalance()-100);
            return new ModelAndView(attributes,"transferirFondos.ftl");

        }, freeMarkerEngine);

        before("/Transacciones", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null){
                response.redirect("/InicioSesion");
            }
        });


        get("/Transacciones", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes,"transacciones.ftl");

        }, freeMarkerEngine);


        before("/Pale", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null){
                response.redirect("/InicioSesion");
            }
            if(str.getCuenta().getBalance() <= 0){
                response.redirect("/Fondos");
            }
        });


        get("/Pale", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes,"pale.ftl");

        }, freeMarkerEngine);

        before("/CompartirGanador", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null){
                response.redirect("/InicioSesion");
            }
        });

        get("/CompartirGanador", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes,"PublicarComentario.ftl");

        }, freeMarkerEngine);

        before("/Usuarios", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null || str.isAdminsitrador() == false){
                response.redirect("/InicioSesion");
            }
        });


        get("/Usuarios", (request, response) -> {

            List<Usuario> usuarios = UsuarioServices.getInstancia().findAll();

            firstTime = true;
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("first", firstTime);
            attributes.put("usuarios", usuarios);
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes,"Usuarios.ftl");

        }, freeMarkerEngine);


        post("/CrearUsuario", (request, response) -> {

            Usuario usuario = new Usuario();
            usuario.setUsuario(request.queryParams("usuario"));

            if(UsuarioServices.getInstancia().find(usuario.getUsuario())==null){

                usuario.setCedula(request.queryParams("cedula"));
                usuario.setNombre(request.queryParams("nombre"));
                usuario.setClave(request.queryParams("clave"));
                usuario.setFechaNacimiento(request.queryParams("fechanac"));


                Cuenta cuenta = new Cuenta(0);
                CuentaServices.getInstancia().crear(cuenta);
                usuario.setCuenta(cuenta);
                UsuarioServices.getInstancia().crear(usuario);
            }
            else {
                response.redirect("/Inicio");
            }



            Map<String, Object> attributes = new HashMap<>();

            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes, "Home.ftl");
        },freeMarkerEngine);

        post("/LoginForm", (request, response) -> {

            String usuario = request.queryParams("usuario");
            String clave = request.queryParams("clave");

            if(UsuarioServices.getInstancia().find(usuario)!=null){
                Usuario userAux = UsuarioServices.getInstancia().find(usuario);
                if(userAux.getClave().equals(clave)){
                    request.session().attribute("usuario", userAux);
                    user1 = userAux;
                    loggeado = true;
                }
            }

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes, "Home.ftl");

        },freeMarkerEngine);

        //before("/Fondos", (request, response) -> {

//            Usuario str = request.session().attribute("usuario");
  //          if (str == null){
    //            response.redirect("/InicioSesion");
      //      }
       // });

        get("/Fondos", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("loggeado",loggeado);
            return new ModelAndView(attributes,"agregarFondos.ftl");

        }, freeMarkerEngine);

        before("/Transacciones", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null){
                response.redirect("/InicioSesion");
            }
        });

        get("/transferirFondos", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            if(UsuarioServices.getInstancia().findAll() != null) {
                List<Usuario> usuarios = UsuarioServices.getInstancia().findAll();
                attributes.put("usuarios", usuarios);
            }else{
                List<Usuario> usuariosAux = new ArrayList<>();
                attributes.put("usuarios", usuariosAux);
            }
            attributes.put("Usrorigen", userAux);
            attributes.put("loggeado", loggeado);

            return new ModelAndView(attributes,"transferirFondos.ftl");

        }, freeMarkerEngine);

        get("/Pale", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();

            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes,"pale.ftl");


        }, freeMarkerEngine);

        post("/Pale", (request, response) -> {

        Map<String, Object> attributes = new HashMap<>();
        int cont = 0;
        int Primero = Integer.parseInt(request.queryParams("primerNumero"));
        int Segundo = Integer.parseInt(request.queryParams("segundoNumero"));
        int Tercero = Integer.parseInt(request.queryParams("tercerNumero"));

        long montoApostado = Long.parseLong(request.queryParams("monto"));

        paleJugados[0] = Primero;
        paleJugados[1] = Segundo;
        paleJugados[2] = Tercero;

        for (int i = 0; i < 3; i++){
            paleGanadores[i] = number.nextInt(12);
        }


        for (int j = 0; j< 3 ; j++){

            if(paleGanadores[j] == paleJugados[0]){
                ganador = true;
            }



        }
        response.redirect("/resultadoPale");
            return null;
        }, freeMarkerEngine);

        before("/ganarPale", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null){
                response.redirect("/InicioSesion");
            }
        });

        get("/ganarPale", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("jugados", paleJugados);
            attributes.put("ganadores", paleGanadores);
            attributes.put("ganador", true);
            return new ModelAndView(attributes,"resultadoPale.ftl");

        }, freeMarkerEngine);

        before("/resultadoPale", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null){
                response.redirect("/InicioSesion");
            }
        });

        get("/resultadoPale", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("jugados", paleJugados);
            attributes.put("ganadores", paleGanadores);
            attributes.put("ganador", ganador);
            return new ModelAndView(attributes,"resultadoPale.ftl");

        }, freeMarkerEngine);

    //    before("/Loto", (request, response) -> {

      //      Usuario str = request.session().attribute("usuario");
        //    if (str == null){
          //      response.redirect("/InicioSesion");
          //  }

           // if(str.getCuenta().getBalance() <= 0){
             //   response.redirect("/Fondos");
           // }
        //});


        get("/Loto", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            //attributes.put("balance", user1.getCuenta().getBalance());
            attributes.put("loggeado", loggeado);
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
                lotoGanadores[i] = number.nextInt(20);
            }


            for (int j = 0; j< 5 ; j++){

                if(lotoGanadores[j] == lotoJugados[j]){
                    cont++;
                }

            }

            if(cont == 5){

                ganador = true;
            }
            response.redirect("/resultadoLoto");
            return null;

        }, freeMarkerEngine);


        before("/ganarLoto", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null){
                response.redirect("/InicioSesion");
            }
        });

        get("/ganarLoto", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("jugados", lotoJugados);
            attributes.put("ganadores", lotoGanadores);
            attributes.put("ganador", true);
            return new ModelAndView(attributes,"resultadoLoto.ftl");

        }, freeMarkerEngine);

        before("/resultadoLoto", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null){
                response.redirect("/InicioSesion");
            }
        });

        get("/resultadoLoto", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("ganadores", lotoGanadores);
            attributes.put("jugados", lotoJugados);
            attributes.put("ganador", ganador);
            return new ModelAndView(attributes,"resultadoLoto.ftl");

        }, freeMarkerEngine);

        before("/EliminarUsuario/:usuario", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null){
                response.redirect("/InicioSesion");
            }
        });


        get("/EliminarUsuario/:usuario", (request, response) -> {

            boolean existe = false;
            String usuario = request.params("usuario");

            UsuarioServices.getInstancia().eliminar(usuario);

            List<Usuario> usuarios = UsuarioServices.getInstancia().findAll();
            if(usuarios.size()>0){
                existe = true;
            }
            Map<String, Object> attributes = new HashMap<>();

            firstTime = false;
            attributes.put("existe", existe);
            attributes.put("usuarios", usuarios);

            return new ModelAndView(attributes, "TableUsuarios.ftl");

        },freeMarkerEngine);

        get("/Ganadores", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();

            if(GanadorServices.getInstancia().findAll() != null){

                attributes.put("ganadores", GanadorServices.getInstancia().findAll());
            }
            else{

                List<Ganador> ganadoresAux = new ArrayList<>();
                attributes.put("ganadores", ganadoresAux);
            }
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes, "Ganadores.ftl");
        },freeMarkerEngine);


        post("/publicarGanador", "multipart/form-data", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();

            List<String> rutas = new ArrayList<>();
            Ganador ganador = new Ganador();
            String file_name = "image";


            Path temp = Paths.get(imageUpload.getAbsolutePath() + file_name+".jpeg");

            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));

            try(InputStream input = request.raw().getPart("image-file").getInputStream()) {


                Files.copy(input, temp, StandardCopyOption.REPLACE_EXISTING);

                byte[] byteI = Files.readAllBytes(temp);
                ganador.setImagen(byteI);
            }

            ganador.setUsuario(userAux);
            ganador.setMensaje(request.queryParams("comentario"));
            GanadorServices.getInstancia().crear(ganador);

            File imageUpload1 = new File(System.getProperty("java.io.tmpdir"));

            List<Ganador> ganadores = GanadorServices.getInstancia().findAll();

            for(Ganador ganadorAux : ganadores){

                File temp2 = File.createTempFile("image", ".jpeg", imageUpload1);

                FileOutputStream fos = new FileOutputStream(temp2);

                fos.write(ganadorAux.getImagen());

                ganadorAux.setRutaImagen(temp2.getName());

                GanadorServices.getInstancia().editar(ganadorAux);
            }

            attributes.put("ganadores", GanadorServices.getInstancia().findAll());
            attributes.put("loggeado", loggeado);
            response.redirect("/Ganadores");

            return null;
        });
        before("/agregarFondos", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null){
                response.redirect("/InicioSesion");
            }
        });


        post("/agregarFondos", (request, response) -> {

            IncrementoFondos fondos = new IncrementoFondos();

            fondos.setMonto(Long.parseLong(request.queryParams("monto")));
            Date fecha = new Date();
            fondos.setFecha(fecha.toString());

           Usuario usuario= request.session().attribute("usuario");

            fondos.setUsuario(usuario);

           // FondosServices.getInstancia().crear(fondos);

            Cuenta cuenta = CuentaServices.getInstancia().findbyusername(usuario.getUsuario());
            cuenta.setBalance(cuenta.getBalance() + fondos.getMonto());
            cuenta.getFondos().add(fondos);

            int opc = Integer.parseInt(request.queryParams("entradaT"));

            if (opc == 3) {
                Tarjeta tarjeta = TarjetaServices.getInstancia().find(request.queryParams("tarjeta"));
                fondos.setTarjeta(tarjeta);
            } else {
                Tarjeta tarjeta = new Tarjeta();

                tarjeta.setNumero(request.queryParams("card-number"));
                tarjeta.setCvc(Short.parseShort(request.queryParams("cvc")));
                tarjeta.setMesVencimiento(request.queryParams("expiry-month"));
                tarjeta.setYearVencimiento(request.queryParams("expiry-year"));

                cuenta.getTarjetas().add(tarjeta);
                fondos.setTarjeta(tarjeta);

                TarjetaServices.getInstancia().crear(tarjeta);
                UsuarioServices.getInstancia().editar(usuario);
            }

            FondosServices.getInstancia().editar(fondos);
            CuentaServices.getInstancia().editar(cuenta);


            response.redirect("/Inicio");
            return null;

        });

        post("/transferirDinero", (request, response) -> {

            Transaccion transaccion = new Transaccion();
            long monto = Long.parseLong(request.queryParams("monto"));
            transaccion.setMontoTransferido(monto);
            Usuario destino = UsuarioServices.getInstancia().find(request.queryParams("usuario"));
            transaccion.setUsuarioDestino(destino);
            transaccion.setUsuarioOrigen(userAux);
            userAux.getCuenta().setBalance(userAux.getCuenta().getBalance() - monto);
            Date fecha = new Date();
            transaccion.setFecha(fecha.toString());
            destino.getCuenta().setBalance(destino.getCuenta().getBalance() + monto);

            TransaccionServices.getInstancia().crear(transaccion);

            userAux.getCuenta().getTransacciones().add(transaccion);

            UsuarioServices.getInstancia().editar(destino);
            UsuarioServices.getInstancia().editar(userAux);

            response.redirect("/transferirFondos");

            return null;
        });

        get("/cerrarSesion", (request, response) -> {

            request.session().invalidate();
            loggeado = false;
            user1 = null;
            response.redirect("/Inicio");
            return null;
        }, freeMarkerEngine );
    }
}
