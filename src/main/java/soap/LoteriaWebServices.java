package soap;


import Entidades.AcumuladoLoto;
import Entidades.Usuario;
import Servicios.AcumuladoLotoServices;
import Servicios.UsuarioServices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.security.SecureRandom;

/**
 * Created by Isaac Perez on 23/7/2017.
 */

@WebService
public class LoteriaWebServices {

    private static int[] paleJugados = new int[3];
    private static int[] paleGanadores = new int[3];
    private static int[] lotoJugados = new int[5];
    private static int[] lotoGanadores = new int[5];
    private static SecureRandom number;
    private static AcumuladoLoto acumuladoLoto;


    @WebMethod
    public String prueba(){
        return "ITS WORKING!";
    }

    @WebMethod
    public String jugarPale(long montoApostado, int Primero, int Segundo, int Tercero, String usuario, String clave, boolean ganador){

        if(ganador){

            return "USTED ES UN GANADOR !!!";
        }
    Usuario str = new Usuario();
        if (UsuarioServices.getInstancia().find(usuario) != null) {
            str = UsuarioServices.getInstancia().find(usuario);
            if (str.getClave().equals(clave)) {

                if(str.getCuenta().getBalance() > montoApostado) {
                    int cont = 0;

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

                    }


                    UsuarioServices.getInstancia().editar(str);

                }
                else {
                    return "Fondos No suficientes";
                }
            }

            else {
                return "Usuario o clave incorrectos";
            }

            if (ganador){
                return "Ganaste";
            }
            else {
                return "Perdiste";
            }
        }

        else {
            return "Usuario o clave incorrectos";
        }
    }

    @WebMethod
    public String jugarLoto(int Primero, int Segundo, int Tercero, int Cuarto, int Quinto, String usuario, String clave, boolean ganador){

        if(ganador){

            return "USTED ES UN GANADOR !!!";
        }
        acumuladoLoto = AcumuladoLotoServices.getInstancia().cargarAcumulado();
        Usuario str = new Usuario();
        if (UsuarioServices.getInstancia().find(usuario) != null) {
            str = UsuarioServices.getInstancia().find(usuario);
            if (str.getClave().equals(clave)) {
                if (str.getCuenta().getBalance() > 50) {

                    str.getCuenta().setBalance(str.getCuenta().getBalance() - 50);

                    int cont = 0;
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


                    AcumuladoLotoServices.getInstancia().editar(acumuladoLoto);
                    UsuarioServices.getInstancia().editar(str);
                }

                else {
                    return "Fondos No Suficientes";
                }


            }

            else {
                return "Usuario o clave incorrectos";
            }

            if (ganador) {
                return "Ganaste";
            } else {
                return "Perdiste";
            }


        }

        else {
            return "Usuario o clave incorrectos";
        }




    }
}


