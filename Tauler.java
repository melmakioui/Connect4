package ProjecteConnecta4;

public class Tauler {

    private char[][] tauler;
    private static final int CONNECTA = 4;
    private static final char CASELLA_BUIDA = '_';
    private static int CONTADOR_FITXES = 0;

    public Tauler() {
        this.tauler = new char[6][8];

        initTablero();
    }

    private void initTablero() {
        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[0].length; j++) {
                tauler[i][j] = CASELLA_BUIDA;
            }
        }
    }


    public boolean comprovaTauler(int columna, char fitxa) {

        int fila = colocaFitxa(columna, fitxa);

        return comprovaEnHorizontal(fila, columna, fitxa)
                || comprovaEnVertical(fila, columna, fitxa)
                || comprovaEnDiagonalDreta(fitxa)
                || comprovaEnDiagonalEsquerra(fitxa);

    }


    private int colocaFitxa(int col, char fitxa) {

        int fila = tauler.length - 1;
        int columna = col;

        if (estaOcupada(tauler[fila][col])) {

            for (int i = fila; i > -1; i--) {
                if (!estaOcupada(tauler[i][columna])) {
                    tauler[i][columna] = fitxa;
                    return i;
                }
            }
        }

        tauler[fila][col] = fitxa;

        return fila;
    }


    private boolean estaOcupada(char casella) {
        return casella != CASELLA_BUIDA;
    }


    private boolean comprovaEnVertical(int fila, int columna, char fitxa) {

        int contador = 0;

        for (int i = fila; i < tauler.length; i++) {
            if (!esIgual(tauler[i][columna], fitxa)) {
                break;
            }
            contador++;
        }

        return contador >= CONNECTA;
    }


    private boolean comprovaEnHorizontal(int fila, int columna, char fitxa) {

        int contador = 0;

        for (int i = columna; i > -1; i--) {
            if (!esIgual(tauler[fila][i], fitxa)) {
                break;
            }
            contador++;
        }

        for (int j = columna + 1; j < tauler[0].length; j++) {
            if (!esIgual(tauler[fila][j], fitxa)) {
                break;
            }
            contador++;
        }

        return contador >= CONNECTA;
    }


    private boolean comprovaEnDiagonalDreta(char fitxa) {

        for (int fila = 3; fila < tauler.length; fila++) {
            for (int col = 0; col < tauler[0].length - 3; col++) {
                if (esDiagonal(fila, col, fitxa)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean esDiagonal(int fila, int columna, char fitxa) {

        CONTADOR_FITXES = 0;

        for (int i = 0; i < tauler.length - 2; i++) {
            if (tauler[fila - i][columna + i] == fitxa) {
                CONTADOR_FITXES++;
            }
        }

        return CONTADOR_FITXES == CONNECTA;
    }




    private boolean comprovaEnDiagonalEsquerra(char fitxa) {



        return false;
    }


    private boolean esIgual(char casella, char fitxa) {
        return casella == fitxa;
    }


    public void imprimirTaula() {


        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[0].length; j++) {
                System.out.print("|" + tauler[i][j] + "|" + " ");
            }
            System.out.println();
        }
    }

}

