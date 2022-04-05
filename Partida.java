package ProjecteConnecta4;

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
    }

}
