package ProjecteConnecta4;

import ProjecteConnecta4.entradasortida.EntradaSortida;

public class Partida {

    private Jugador[] jugadors;
    private Tauler tauler;


    public Partida(Jugador[] jugadors, Tauler tauler) {

        this.jugadors = jugadors;
        this.tauler = tauler;

        initPartida(jugadors, tauler);
    }


    private void initPartida(Jugador[] jugadors, Tauler tauler) {

        int posicio;
        int torn = 0;

        while ( !jugadors [ torn ] .esGuanyador() ) {

            posicio = EntradaSortida.triaPosicio( jugadors [ torn ] );

            if ( comprovaSiEsGuanyador( jugadors [ torn ], posicio) ) { //REFACTORITZAR EN UN METODE
                tauler.imprimirTaula();
                continue;
            }

            tauler.imprimirTaula();

            //  % --> Torna enrera;
        }

    }



    private boolean comprovaSiEsGuanyador(Jugador jugador, int posicio) {

        return tauler.comprovaTauler(posicio, jugador.getFitxa())
                && jugador.haGuanyat(true);

    }


}
