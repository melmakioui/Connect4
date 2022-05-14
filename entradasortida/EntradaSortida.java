package ProjecteConnecta4.entradasortida;

import ProjecteConnecta4.Jugador;
import ProjecteConnecta4.Tauler;

import java.util.Scanner;

public class EntradaSortida {


    private static final int MAXIM_COLUMNES = 8;

    public static int triaPosicio(Jugador jugador) {

        Scanner entrada = new Scanner(System.in);

        System.out.println();
        System.out.println("TIRA " + jugador.getNom() );
        System.out.print("> ");
        int posicio = entrada.nextInt();

        while (posicio < 0 || posicio > MAXIM_COLUMNES) {
            System.out.println("NO EXISTEIX AQUESTA POSICIO");
            System.out.print("> ");
            posicio = entrada.nextInt();
        }

        return posicio -1;
    }

    public static void mostraColumnaPlena(){
        System.out.println("COLUMNA PLENA!!");
    }





}
