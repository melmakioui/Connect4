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

        int posicio;

        while (!jugadorUn.esGuanyador() && !jugadorDos.esGuanyador()) {

            posicio = EntradaSortida.triaPosicio(jugadorUn);
            if (comprovaSiEsGuanyador(jugadorUn, posicio)) { //REFACTORITZAR EN UN METODE
                tauler.imprimirTaula();
                continue;
            }


            tauler.imprimirTaula();


            posicio = EntradaSortida.triaPosicio(jugadorDos);
            if (comprovaSiEsGuanyador(jugadorDos, posicio)) {
                tauler.imprimirTaula();
                continue;
            }


            tauler.imprimirTaula();

        }

    }



    private boolean comprovaSiEsGuanyador(Jugador jugador, int posicio) {

        return tauler.comprovaTauler(posicio, jugador.getFitxa())
                && jugador.haGuanyat(true);

    }


}
