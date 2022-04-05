package ProjecteConnecta4;

public class Main {


    public static void main(String[] args) {

        Fitxa fitxaJugadorUn = new Fitxa('X');
        Jugador jugadorUn = new Jugador("Player 1", fitxaJugadorUn);

        Fitxa fitxaJugadorDos = new Fitxa('O');
        Jugador jugadorDos = new Jugador("Player 2", fitxaJugadorDos);

        Tauler tauler = new Tauler();

        Partida partida = new Partida(jugadorUn, jugadorDos, tauler);

    }




}
