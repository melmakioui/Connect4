package ProjecteConnecta4;

public class Tauler {

    private char[][] tauler;
    private Casella casella;
    private static final int CONNECTA = 4;

    public Tauler() {
        this.tauler = new char[7][8];
        this.casella = new Casella();

        initTablero();
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


    public boolean comprovaTauler(int columna, char fitxa) {

        int fila = colocaFitxa(columna, fitxa);

        return comprovaEnParalelHorizontal(fila,columna,fitxa)
                || comprovaEnParalelVertical(fila,columna,fitxa);

    }


    private int colocaFitxa(int pos, char fitxa) {

        int fila = tauler.length - 1;
        int columna = pos;

        if (tauler[fila][pos] != casella.estaDesocupada()) {

            for (int i = fila; i > -1; i--) {
                if (tauler[i][columna] == casella.estaDesocupada()) {
                    tauler[i][columna] = fitxa;
                    return i;
                }
            }
        }

        tauler[fila][pos] = fitxa;

        return fila;
    }


    private boolean comprovaEnParalelVertical(int fila, int col, char fitxa) {

        int contador = 0;
        //ABAIX VV
        for (int i = fila; i < tauler.length; i++) {
            if (tauler[i][col] == fitxa)
                contador++;
        }

        if (contador == CONNECTA)
            return true;

        //AMUNT ^^
        for (int j = fila - 1; j != -1; j--) {
            if (tauler[j][col] == fitxa)
                contador++;
        }

        return contador == CONNECTA;
    }


    private boolean comprovaEnParalelHorizontal(int fila, int col, char fitxa) {

        int contador = 0;

        //ESQUERRA <--
        for (int i = col; i > -1; i--) {
            if (tauler[fila][i] == fitxa)
                contador++;
        }

        if (contador == CONNECTA)
            return true;


        //DRETA -->
        for (int j = col + 1; j < tauler[0].length; j++) {
            if (tauler[fila][j] == fitxa)
                contador++;
        }

        return contador == CONNECTA;
    }


}
