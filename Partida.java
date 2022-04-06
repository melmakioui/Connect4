package ProjecteConnecta4;

import ProjecteConnecta4.entradasortida.EntradaSortida;

public class Partida {

    private Jugador jugadorUn;
    private Jugador jugadorDos;
    private Tauler tauler;


    public Partida(Jugador jugadorUn, Jugador jugadorDos, Tauler tauler) {

        this.jugadorUn = jugadorUn;
        this.jugadorDos = jugadorDos;
        this.tauler = tauler;

        initPartida(jugadorUn, jugadorDos, tauler);
    }


    private void initPartida(Jugador jugadorUn, Jugador jugadorDos, Tauler tauler) {

        int posicio = 0;

        while (!jugadorUn.esGuanyador() && !jugadorDos.esGuanyador()) {


            if (esTurnDeJugador(jugadorUn, posicio)) {
                tauler.imprimirTaula();
                continue;
            }

            tauler.imprimirTaula();

            if (esTurnDeJugador(jugadorDos, posicio)) {
                tauler.imprimirTaula();
            }

            tauler.imprimirTaula();


        }

    }


    private boolean esTurnDeJugador(Jugador jugador, int posicio) {

        posicio = EntradaSortida.triaPosicio(jugador);

        if (tauler.comprovaTauler ( posicio, jugador.getFitxa() )) {
            return jugador.haGuanyat(true);
        }

        return false;
    }


}
