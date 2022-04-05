package ProjecteConnecta4;

import ProjecteConnecta4.entradasortida.EntradaSortida;

public class Partida {

    private Jugador jugadorUn;
    private Jugador jugadorDos;
    private Casella casella;
    private Tauler tauler;
    private Fitxa fitxa;


    public Partida (Jugador jugadorUn, Jugador jugadorDos, Tauler tauler) {

        this.jugadorUn = jugadorUn;
        this.jugadorDos = jugadorDos;
        this.tauler = tauler;

        initPartida(jugadorUn, jugadorDos, tauler);
    }


    private void initPartida(Jugador jugadorUn, Jugador jugadorDos, Tauler tauler) {

        int posicio;

        while ( !jugadorUn.esGuanyador() || !jugadorDos.esGuanyador() ) {

            posicio = EntradaSortida.triaPosicio(jugadorUn);
            comprovaSiEsGuanyador(jugadorUn, posicio);

            posicio = EntradaSortida.triaPosicio(jugadorDos);
            comprovaSiEsGuanyador(jugadorDos, posicio);

        }

    }


    private boolean comprovaSiEsGuanyador(Jugador jugador, int posicio) {

        return tauler.comprovaTauler(posicio, jugador.getFitxa().getCaraFitxa()) && jugador.esGuanyador();

    }



}
