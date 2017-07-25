package Main; /**
 * Created by darle on 6/26/2017.
 */

import Entidades.*;
import Servicios.*;
import Utilidades.JsonUtilidades;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import freemarker.template.Configuration;
import soap.SoapArranque;
import spark.ModelAndView;
import spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import javax.servlet.MultipartConfigElement;
import java.io.*;
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

    private static boolean entra = false;
    private static AcumuladoLoto acumuladoLoto;

    public static File imageUpload = new File("./src/main/resources/img");
    static boolean loggeado = false;
    static boolean firstTime = false;
    static  Usuario userAux = null;
    static int page = 1;
    public final static int  BAD_REQUEST = 400;
    public final static int ERROR_INTERNO = 500;
    public static void main(String[] args) throws Exception {

        port(4567);

        SoapArranque.init();
        staticFiles.location("/");
        staticFiles.externalLocation(System.getProperty("java.io.tmpdir"));

        enableDebugScreen();
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setClassForTemplateLoading(main.class, "/Templates");
        FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine(configuration);


        BootStrapService.getInstancia().init();

        Usuario admin = new Usuario("", "admin", "admin", "admin", "");
        admin.setAdminsitrador(true);

       //AcumuladoLotoServices.getInstancia().editar(acumuladoLoto);


        try {
            number = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException nsae) {
            // Process the exception in some way or the other
        }

        JuegosServices juegosServices = new JuegosServices().getInstancia();


        exception(IllegalArgumentException.class, (exception, request, response) -> {
            manejarError(BAD_REQUEST,exception, request, response);
        });

        exception(JsonSyntaxException.class, (exception, request, response) -> {
            manejarError(BAD_REQUEST,exception, request, response);
        });

        exception(Exception.class, (exception, request, response) -> {
            manejarError(ERROR_INTERNO,exception, request, response);
        });

        get("/Inicio", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes, "Home.ftl");

        }, freeMarkerEngine);

        get("/InicioSesion", (request, response) -> {


            Map<String, Object> attributes = new HashMap<>();
            return new ModelAndView(attributes, "Login.ftl");

        }, freeMarkerEngine);

        get("/NuevoUsuario", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes, "Registro.ftl");

        }, freeMarkerEngine);


        before("/AgregarFondos", (request, response) -> {

            entra = true;
            Usuario str = request.session().attribute("usuario");
            if (str == null) {
                response.redirect("/InicioSesion");
            }
        });

        get("/AgregarFondos", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            Usuario usuario = request.session().attribute("usuario");

            boolean cargar = false;
            if (usuario.getCuenta().getTarjetas() != null) {
                cargar = true;
                List<Tarjeta> tarjetas = UsuarioServices.getInstancia().find(usuario.getUsuario()).getCuenta().getTarjetas();
                attributes.put("tarjetas", tarjetas);

            }

            attributes.put("balance", usuario.getCuenta().getBalance());
            attributes.put("cargar", cargar);
            attributes.put("loggeado", loggeado);
            UsuarioServices.getInstancia().editar(usuario);
            return new ModelAndView(attributes, "agregarFondos.ftl");

        }, freeMarkerEngine);

        before("/transferirFondos", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null) {
                response.redirect("/InicioSesion");
            }
        });

        get("/transferirFondos", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            Usuario str = request.session().attribute("usuario");

            long monto = str.getCuenta().getBalance();
            monto = monto - 100;
            attributes.put("loggeado", loggeado);
            attributes.put("balance", str.getCuenta().getBalance());
            attributes.put("maxTransferencia", monto);
            attributes.put("usuarios", UsuarioServices.getInstancia().findAll());
            attributes.put("Usrorigen", str);

            return new ModelAndView(attributes, "transferirFondos.ftl");

        }, freeMarkerEngine);

        before("/Transacciones", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null) {
                response.redirect("/InicioSesion");
            }
        });


        get("/Transacciones", (request, response) -> {

            Usuario str = request.session().attribute("usuario");

            boolean mostrar = false;
            if (str.getCuenta().getTransacciones().size() > 0) {
                mostrar = true;
            }
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("mostrar", mostrar);
            attributes.put("transacciones", str.getCuenta().getTransacciones());
            attributes.put("usuario", str);
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes, "transacciones.ftl");

        }, freeMarkerEngine);


        before("/Pale", (request, response) -> {

            Usuario str = request.session().attribute("usuario");

            if (str == null) {
                response.redirect("/InicioSesion");
            }
            if (str.getCuenta().getBalance() <= 0) {
                response.redirect("/AgregarFondos");
            }
        });


        get("/Pale", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("balance", str.getCuenta().getBalance());
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes, "pale.ftl");

        }, freeMarkerEngine);

        before("/CompartirGanador", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null) {
                response.redirect("/InicioSesion");
            }
        });

        get("/CompartirGanador", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("loggeado", loggeado);
            Ganador ganador = new Ganador();
            return new ModelAndView(attributes, "PublicarComentario.ftl");

        }, freeMarkerEngine);

        before("/Usuarios", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null || str.isAdminsitrador() == false) {
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
            return new ModelAndView(attributes, "Usuarios.ftl");

        }, freeMarkerEngine);


        post("/CrearUsuario", (request, response) -> {

            Usuario usuario = new Usuario();
            usuario.setUsuario(request.queryParams("usuario"));

            if (UsuarioServices.getInstancia().find(usuario.getUsuario()) == null) {

                usuario.setCedula(request.queryParams("cedula"));
                usuario.setNombre(request.queryParams("nombre"));
                usuario.setClave(request.queryParams("clave"));
                usuario.setFechaNacimiento(request.queryParams("fechanac"));


                Cuenta cuenta = new Cuenta(0);
                CuentaServices.getInstancia().crear(cuenta);
                usuario.setCuenta(cuenta);
                UsuarioServices.getInstancia().crear(usuario);
            } else {
                response.redirect("/Inicio");
            }


            Map<String, Object> attributes = new HashMap<>();

            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes, "Home.ftl");
        }, freeMarkerEngine);

        post("/LoginForm", (request, response) -> {

            String usuario = request.queryParams("usuario");
            String clave = request.queryParams("clave");

            if (UsuarioServices.getInstancia().find(usuario) != null) {
                Usuario userAux = UsuarioServices.getInstancia().find(usuario);
                if (userAux.getClave().equals(clave)) {
                    request.session().attribute("usuario", userAux);
                    user1 = userAux;
                    loggeado = true;
                }
            } else if (usuario.equals("admin") && clave.equals("admin")) {
                request.session().attribute("usuario", admin);
                loggeado = true;
            }

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes, "Home.ftl");

        }, freeMarkerEngine);

        /* before("/Fondos", (request, response) -> {

             Usuario str = request.session().attribute("usuario");
             if (str == null){
                 response.redirect("/InicioSesion");
             }
         });

        get("/Fondos", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("loggeado",loggeado);
            return new ModelAndView(attributes,"agregarFondos.ftl");

        }, freeMarkerEngine);
        */

        before("/Transacciones", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null) {
                response.redirect("/InicioSesion");
            }
        });

        get("/transferirFondos", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();

            if (UsuarioServices.getInstancia().findAll() != null) {
                List<Usuario> usuarios = UsuarioServices.getInstancia().findAll();
                attributes.put("usuarios", usuarios);
            } else {
                List<Usuario> usuariosAux = new ArrayList<>();
                attributes.put("usuarios", usuariosAux);
            }
            attributes.put("Usrorigen", userAux);
            attributes.put("loggeado", loggeado);

            return new ModelAndView(attributes, "transferirFondos.ftl");

        }, freeMarkerEngine);


        post("/Pale", (request, response) -> {

            long montoApostado = Long.parseLong(request.queryParams("monto"));
            Usuario str = request.session().attribute("usuario");

            Juego juego = new Juego();
            str.getCuenta().setBalance(str.getCuenta().getBalance() - montoApostado);


            if (str.getCuenta().getBalance() > montoApostado) {


                if (request.queryParams("ganar") != null) {
                    int Primero = Integer.parseInt(request.queryParams("primerNumero"));
                    int Segundo = Integer.parseInt(request.queryParams("segundoNumero"));
                    int Tercero = Integer.parseInt(request.queryParams("tercerNumero"));

                    paleGanadores[0] = paleJugados[0] = Primero;
                    paleGanadores[1] = paleJugados[1] = Segundo;
                    paleGanadores[2] = paleJugados[2] = Tercero;

                    str.getCuenta().setBalance(str.getCuenta().getBalance() + (montoApostado * 1000));
                    ganador = true;


                    juego.setGanador(true);
                    juego.setMontoGanado(montoApostado*1000);


                } else {


                    int cont = 0;
                    int Primero = Integer.parseInt(request.queryParams("primerNumero"));
                    int Segundo = Integer.parseInt(request.queryParams("segundoNumero"));
                    int Tercero = Integer.parseInt(request.queryParams("tercerNumero"));


                    paleJugados[0] = Primero;
                    paleJugados[1] = Segundo;
                    paleJugados[2] = Tercero;

                    for (int i = 0; i < 3; i++) {
                        paleGanadores[i] = number.nextInt(12);
                    }


                    for (int j = 0; j < 3; j++) {

                        if (paleGanadores[j] == paleJugados[j]) {
                            cont++;
                        }
                    }

                    if (cont == 3) {

                        str.getCuenta().setBalance(str.getCuenta().getBalance() + (montoApostado * 1000));
                        ganador = true;
                        juego.setGanador(true);
                        juego.setMontoGanado(montoApostado*1000);
                    }
                }


                String fecha = new Date().toString();
                juego.setFecha(fecha);
                juego.setMontoApostado(montoApostado);
                juego.setPale(true);
                str.getJuegos().add(juego);

                UsuarioServices.getInstancia().editar(str);
                response.redirect("/resultadoPale");
            } else {
                response.redirect("/AgregarFondos");
            }

            return null;
        });


        before("/resultadoPale", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null) {
                response.redirect("/InicioSesion");
            }
        });

        get("/resultadoPale", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("jugados", paleJugados);
            attributes.put("ganadores", paleGanadores);
            attributes.put("ganador", ganador);
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes, "resultadoPale.ftl");

        }, freeMarkerEngine);

        before("/Loto", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null) {
                response.redirect("/InicioSesion");
            }


            if (str.getCuenta().getBalance() <= 0) {
                response.redirect("/AgregarFondos");
            }
        });


        get("/Loto", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();

            acumuladoLoto = AcumuladoLotoServices.getInstancia().cargarAcumulado();
            Usuario str = request.session().attribute("usuario");
            if (str.getCuenta().getBalance() < 50) {
                response.redirect("/AgregarFondos");
            } else {

                attributes.put("acumulado", acumuladoLoto.getAcumulado());
                attributes.put("balance", str.getCuenta().getBalance());
                attributes.put("loggeado", loggeado);

            }

            return new ModelAndView(attributes, "loto.ftl");
        }, freeMarkerEngine);

        post("/Loto", (request, response) -> {

            Usuario str = request.session().attribute("usuario");


            acumuladoLoto = AcumuladoLotoServices.getInstancia().cargarAcumulado();

            str.getCuenta().setBalance(str.getCuenta().getBalance() - 50);


            if (request.queryParams("ganar") != null) {


                lotoGanadores[0] = lotoJugados[0] = Integer.parseInt(request.queryParams("primerNumero"));
                lotoGanadores[1] = lotoJugados[1] = Integer.parseInt(request.queryParams("segundoNumero"));
                lotoGanadores[2] = lotoJugados[2] = Integer.parseInt(request.queryParams("tercerNumero"));
                lotoGanadores[3] = lotoJugados[3] = Integer.parseInt(request.queryParams("cuartoNumero"));
                lotoGanadores[4] = lotoJugados[4] = Integer.parseInt(request.queryParams("quintoNumero"));

                str.getCuenta().setBalance(str.getCuenta().getBalance() + acumuladoLoto.getAcumulado());

                acumuladoLoto.setAcumulado(0);
                AcumuladoLotoServices.getInstancia().editar(acumuladoLoto);
                ganador = true;
            } else {
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

                for (int i = 0; i < 5; i++) {
                    lotoGanadores[i] = number.nextInt(20);
                }


                for (int j = 0; j < 5; j++) {

                    if (lotoGanadores[j] == lotoJugados[j]) {
                        cont++;
                    }

                }

                if (cont == 5) {

                    str.getCuenta().setBalance(str.getCuenta().getBalance() + acumuladoLoto.getAcumulado());
                    acumuladoLoto.setAcumulado(0);
                    AcumuladoLotoServices.getInstancia().editar(acumuladoLoto);
                    ganador = true;

                } else {
                    acumuladoLoto.setAcumulado(acumuladoLoto.getAcumulado() + 50);
                    AcumuladoLotoServices.getInstancia().editar(acumuladoLoto);
                }
            }

            AcumuladoLotoServices.getInstancia().editar(acumuladoLoto);
            UsuarioServices.getInstancia().editar(str);

            response.redirect("/resultadoLoto");
            return null;

        }, freeMarkerEngine);


        before("/ganarLoto", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null) {
                response.redirect("/InicioSesion");
            }
        });

        get("/ganarLoto", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("jugados", lotoJugados);
            attributes.put("ganadores", lotoGanadores);
            attributes.put("ganador", true);
            return new ModelAndView(attributes, "resultadoLoto.ftl");

        }, freeMarkerEngine);

        before("/resultadoLoto", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null) {
                response.redirect("/InicioSesion");
            }
        });

        get("/resultadoLoto", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();
            attributes.put("ganadores", lotoGanadores);
            attributes.put("jugados", lotoJugados);
            attributes.put("ganador", ganador);
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes, "resultadoLoto.ftl");

        }, freeMarkerEngine);

        before("/EliminarUsuario/:usuario", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null) {
                response.redirect("/InicioSesion");
            }
        });


        get("/EliminarUsuario/:usuario", (request, response) -> {

            boolean existe = false;
            String usuario = request.params("usuario");

            UsuarioServices.getInstancia().eliminar(usuario);

            List<Usuario> usuarios = UsuarioServices.getInstancia().findAll();
            if (usuarios.size() > 0) {
                existe = true;
            }
            Map<String, Object> attributes = new HashMap<>();

            firstTime = false;
            attributes.put("existe", existe);
            attributes.put("usuarios", usuarios);

            return new ModelAndView(attributes, "TableUsuarios.ftl");

        }, freeMarkerEngine);


        before("/CambiarPermisos/:usuario", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null) {
                response.redirect("/InicioSesion");
            }
        });

        get("/CambiarPermisos/:usuario", (request, response) -> {

            boolean existe = false;

            Usuario user = UsuarioServices.getInstancia().find(request.params("usuario"));
            if (user.isAdminsitrador()) {
                user.setAdminsitrador(false);
            } else {
                user.setAdminsitrador(true);
            }

            UsuarioServices.getInstancia().editar(user);
            List<Usuario> usuarios = UsuarioServices.getInstancia().findAll();

            Map<String, Object> attributes = new HashMap<>();

            firstTime = false;
            attributes.put("existe", true);
            attributes.put("usuarios", usuarios);

            return new ModelAndView(attributes, "TableUsuarios.ftl");

        }, freeMarkerEngine);


        before("/Ganadores", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            List<Ganador> ganadores = GanadorServices.getInstancia().findAll();
            if (ganadores == null || str == null) {
                response.redirect("/Inicio");
            }
        });


        get("/Ganadores", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();

            attributes.put("ganadores", GanadorServices.getInstancia().findAll());
            attributes.put("loggeado", loggeado);
            return new ModelAndView(attributes, "Ganadores.ftl");
        }, freeMarkerEngine);


        post("/publicarGanador", "multipart/form-data", (request, response) -> {

            Map<String, Object> attributes = new HashMap<>();


            Ganador ganador = new Ganador();
            String file_name = "image";

            Usuario str = request.session().attribute("usuario");
            Path temp = Paths.get(imageUpload.getAbsolutePath() + file_name + ".jpeg");

            request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
            ganador.setDireccion(getStringFromInputStream(request.raw().getPart("lugar").getInputStream()));



            try (InputStream input = request.raw().getPart("image-file").getInputStream()) {


                Files.copy(input, temp, StandardCopyOption.REPLACE_EXISTING);

                byte[] byteI = Files.readAllBytes(temp);
                ganador.setImagen(byteI);
            }


            ganador.setUsuario(str);
            ganador.setMensaje(request.queryParams("comentario"));
            GanadorServices.getInstancia().crear(ganador);

            File imageUpload1 = new File(System.getProperty("java.io.tmpdir"));

            List<Ganador> ganadores = GanadorServices.getInstancia().findAll();

            for (int i = 0; i < ganadores.size(); i++) {

                File temp2 = File.createTempFile("image", ".jpeg", imageUpload1);

                FileOutputStream fos = new FileOutputStream(temp2);

                fos.write(ganadores.get(i).getImagen());

                ganadores.get(i).setRutaImagen(temp2.getName());

                GanadorServices.getInstancia().editar(ganadores.get(i));
            }

            attributes.put("ganadores", GanadorServices.getInstancia().findAll());
            attributes.put("loggeado", loggeado);

            return new ModelAndView(attributes, "Ganadores.ftl");
        }, freeMarkerEngine);
        before("/agregarFondos", (request, response) -> {

            Usuario str = request.session().attribute("usuario");
            if (str == null) {
                response.redirect("/InicioSesion");
            }
        });

        get("/HistorialIngresos", (request, response) -> {
            Usuario str = request.session().attribute("usuario");
            boolean mostrar = false;
            if (str.getCuenta().getFondos().size() > 0) {
                mostrar = true;
            }
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("loggeado", loggeado);
            attributes.put("mostrar", mostrar);
            attributes.put("fondos", str.getCuenta().getFondos());
            return new ModelAndView(attributes, "TablaIngresos.ftl");
        }, freeMarkerEngine);

        post("/agregarFondos", (request, response) -> {

            IncrementoFondos fondos = new IncrementoFondos();

            Usuario usuario = request.session().attribute("usuario");

            usuario.getCuenta().setBalance(usuario.getCuenta().getBalance() + Long.parseLong(request.queryParams("monto")));
            UsuarioServices.getInstancia().editar(usuario);

            int opc = Integer.parseInt(request.queryParams("entradaT"));

            if (opc == 3) {
                Tarjeta tarjeta = TarjetaServices.getInstancia().find(Long.parseLong(request.queryParams("tarjeta")));
                fondos.setTarjeta(tarjeta);
            } else {
                Tarjeta tarjeta = new Tarjeta();

                tarjeta.setNumero(request.queryParams("card-number"));
                tarjeta.setCvc(Short.parseShort(request.queryParams("cvc")));
                tarjeta.setMesVencimiento(request.queryParams("expiry-month"));
                tarjeta.setYearVencimiento(request.queryParams("expiry-year"));

                fondos.setTarjeta(tarjeta);

                TarjetaServices.getInstancia().crear(tarjeta);
                UsuarioServices.getInstancia().editar(usuario);
            }

            FondosServices.getInstancia().editar(fondos);



            response.redirect("/Inicio");
            return null;

        });

        post("/transferirDinero", (request, response) -> {

            Usuario str = request.session().attribute("usuario");

            Transaccion transaccion = new Transaccion();
            long monto = Long.parseLong(request.queryParams("monto"));
            transaccion.setMontoTransferido(monto);
            Usuario destino = UsuarioServices.getInstancia().find(request.queryParams("usuario"));
            transaccion.setUsuarioDestino(destino);
            transaccion.setUsuarioOrigen(str);
            str.getCuenta().setBalance(str.getCuenta().getBalance() - monto);
            Date fecha = new Date();
            transaccion.setFecha(fecha.toString());
            destino.getCuenta().setBalance(destino.getCuenta().getBalance() + monto);

            TransaccionServices.getInstancia().crear(transaccion);

            str.getCuenta().getTransacciones().add(transaccion);

            UsuarioServices.getInstancia().editar(destino);
            UsuarioServices.getInstancia().editar(str);

            response.redirect("/transferirFondos");

            return null;
        });

        get("/cerrarSesion", (request, response) -> {

            request.session().invalidate();
            loggeado = false;
            user1 = null;
            response.redirect("/Inicio");
            return null;
        }, freeMarkerEngine);

        get("/GanadoresPaginacion", (request, response) -> {


            page++;
            List<Ganador> ganadores = GanadorServices.getInstancia().cargarGanadores(page);


            Map<String, Object> attributes = new HashMap<>();
            attributes.put("ganadores", ganadores);
            return new ModelAndView(attributes, "index.ftl");

        }, freeMarkerEngine);

        get("/GanadoresNext", (request, response) -> {

            page++;


            List<Ganador> ganadores = GanadorServices.getInstancia().cargarGanadores(page);
            Map<String, Object> attributes = new HashMap<>();

            attributes.put("numPag", page);
            attributes.put("ganadores", ganadores);
            return new ModelAndView(attributes, "CargaArticulos.ftl");

        }, freeMarkerEngine);

                //listar todos los estudiantes.
                get("/:usuario", (request, response) -> {

                    Usuario usr = UsuarioServices.getInstancia().find(request.params("usuario"));
                    return usr.getJuegos();
                }, JsonUtilidades.json());
    }

    private static void manejarError(int codigo,Exception exception, Request request, Response response ){
        response.status(codigo);
        response.body(JsonUtilidades.toJson(new ErrorRespuesta(100, exception.getMessage())));
        exception.printStackTrace();
    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }
}
