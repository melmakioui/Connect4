package ProjecteConnecta4;

public class Tauler {

    private char[][] tauler;
    private Casella casella;
    private static final int CONNECTA = 4;

    public Tauler(){
        this.tauler = new char[7][8];
        this.casella = new Casella();

    }

    private void initTablero() {
        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[0].length; j++) {
                tauler[i][j] = casella.estaDesocupada();
            }
        }
    }

}
