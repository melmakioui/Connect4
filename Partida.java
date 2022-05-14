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

        int posicio = 0;
        int torn = 0;
        tauler.mostraTaula();

        do {
            posicio = EntradaSortida.triaPosicio(jugadors[torn]);

            if (esColumnaNoValida(posicio, torn))
                continue;

            tauler.mostraTaula();

            if (jugadors[torn].haGuanyat(esGuanyador(jugadors[torn])))
                continue;

            torn++;
            torn = torn % jugadors.length;

        } while (!jugadors[torn].esGuanyador());


        System.out.println("\n****" + jugadors[torn].getNom() + " HA GUANYAT!!" + "****");

    }

    private boolean esColumnaNoValida(int posicio, int torn) {
        return tauler.colocaFitxa(posicio, jugadors[torn].getFitxa());
    }

    private boolean esGuanyador(Jugador jugador) {
        return tauler.comprovaTauler(jugador.getFitxa());
    }


}
