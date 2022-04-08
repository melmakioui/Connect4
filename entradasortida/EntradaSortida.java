package ProjecteConnecta4.entradasortida;

import ProjecteConnecta4.Jugador;

import java.util.Scanner;

public class EntradaSortida {


    private static final int MAXIM_FILES = 7;

    public static int triaPosicio(Jugador jugador) {

        Scanner entrada = new Scanner(System.in);

        System.out.println();
        System.out.println("TIRA " + jugador.getNom() );
        int posicio = entrada.nextInt();

        while (posicio > MAXIM_FILES || posicio < 0) {
            System.out.println("TRIA UNA POICIO CORRECTAMENT...");
            posicio = entrada.nextInt();
        }

        return posicio -1;
    }

}
