package ProjecteConnecta4;

public class Main {


    public static void main(String[] args) {

        Jugador jugadorUn = new Jugador("Player 1", 'X');

        Jugador jugadorDos = new Jugador("Player 2", 'O');

        Tauler tauler = new Tauler();

        Partida partida = new Partida(jugadorUn, jugadorDos, tauler);

    }




}
