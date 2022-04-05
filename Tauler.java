package ProjecteConnecta4;

public class Tauler {

    private char[][] tauler;
    private Casella casella;
    private static final int CONNECTA = 4;

    public Tauler() {
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


    public void imprimirTaula() {

        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[0].length; j++) {
                System.out.print(tauler[i][j] + "   ");
            }
            System.out.println();
        }
    }

    


    private int colocaFitxa(int pos, char fitxa) {

        int fila = tauler.length - 1;
        int columna = pos;

        if (tauler[fila][pos] != casella.estaDesocupada()) {

            for (int i = fila; i > -1; i--) {
                if (tauler[ i ][ columna ] == casella.estaDesocupada()) {
                    tauler[ i ][ columna ] = fitxa;
                    return i;
                }
            }
        }

        tauler[fila][pos] = fitxa;

        return fila;
    }


}
