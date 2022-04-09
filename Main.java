package ProjecteConnecta4;

public class Main {


    public static void main(String[] args) {

        Jugador[] jugadors = {
                new Jugador("Player 1", 'X'),
                new Jugador("Player 2", 'O')
        };

        Tauler tauler = new Tauler();

        Partida partida = new Partida(jugadors, tauler);

    }




}
