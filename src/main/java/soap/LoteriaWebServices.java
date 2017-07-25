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
    private static boolean ganador = false;
    private static SecureRandom number;
    private static AcumuladoLoto acumuladoLoto;


    @WebMethod
    public String prueba(){
        return "TINY RICK MADAFAKAR!!!";
    }

    @WebMethod
    public String jugarPale(long montoApostado, int Primero, int Segundo, int Tercero, Usuario str){

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

        if (ganador == true){
            return "Ganaste";
        }
        else {
            return "Perdiste";
        }
    }

    @WebMethod
    public String jugarLoto(long montoApostado, int Primero, int Segundo, int Tercero, int Cuarto, int Quinto, Usuario str){

        acumuladoLoto = AcumuladoLotoServices.getInstancia().cargarAcumulado();

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

            }
            else {
                acumuladoLoto.setAcumulado(acumuladoLoto.getAcumulado() + 50);
                AcumuladoLotoServices.getInstancia().editar(acumuladoLoto);
            }


        AcumuladoLotoServices.getInstancia().editar(acumuladoLoto);
        UsuarioServices.getInstancia().editar(str);

        if (ganador == true){
            return "Ganaste";
        }
        else {
            return "Perdiste";
        }



    }
}


