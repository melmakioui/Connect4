package ProjecteConnecta4;

import ProjecteConnecta4.entradasortida.EntradaSortida;

public class Tauler {

    private char[][] tauler;
    private final static int CONNECTA = 4;
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

        colocaFitxa(columna, fitxa);

        return comprovaEnHorizontal(fitxa)
                || comprovaEnVertical(fitxa)
                || comprovaEnDiagonalDreta(fitxa)
                || comprovaEnDiagonalEsquerra(fitxa);

    }


    private void colocaFitxa(int columna, char fitxa) {

        int fila = tauler.length - 1;

        if (estaOcupada(tauler[fila][columna])) {

            for (int i = fila; i > -1; i--) {
                if (!estaOcupada(tauler[i][columna])) {
                    tauler[i][columna] = fitxa;
                    break;
                }
            }
        } else tauler[fila][columna] = fitxa;

    }


    private boolean estaOcupada(char casella) {
        return casella != CASELLA_BUIDA;
    }


    private boolean comprovaEnVertical(char fitxa) {

        for (int fila = 2; fila > -1; fila--) {
            for (int col = 0; col < tauler[0].length; col++) {
                if (connectaVertical(fila, col, fitxa)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean connectaVertical(int fila, int columna, char fitxa) {

        CONTADOR_FITXES = 0;

        for (int i = 0; i < tauler.length - 2; i++) {
            if (esMateixaFitxa(tauler[fila + i][columna], fitxa)) {
                CONTADOR_FITXES++;
            }
        }
        return CONTADOR_FITXES == CONNECTA;
    }


    private boolean comprovaEnHorizontal(char fitxa) {

        for (int fila = 0; fila < tauler.length; fila++) {
            for (int col = 0; col < tauler.length - 2; col++) {
                if (connectaHoritzontal(fila, col, fitxa)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean connectaHoritzontal(int fila, int columna, char fitxa) {

        CONTADOR_FITXES = 0;

        for (int i = 0; i < tauler.length - 1; i++) {
            if (esMateixaFitxa(tauler[fila][columna + i], fitxa)) {
                CONTADOR_FITXES++;
            }
        }

        return CONTADOR_FITXES == CONNECTA;

    }



    private boolean comprovaEnDiagonalDreta(char fitxa) {

        for (int fila = 3; fila < tauler.length; fila++) {
            for (int col = 0; col < tauler[0].length - 3; col++) {
                if (connectaDiagonalDreta(fila, col, fitxa)) {
                    return true;
                }
            }
        }
        return false;
    }




    private boolean connectaDiagonalDreta(int fila, int columna, char fitxa) {

        CONTADOR_FITXES = 0;

        for (int i = 0; i < tauler.length - 2; i++) {
            if (esMateixaFitxa(tauler[fila - i][columna + i], fitxa)) {
                CONTADOR_FITXES++;
            }
        }

        return CONTADOR_FITXES == CONNECTA;
    }




    private boolean comprovaEnDiagonalEsquerra(char fitxa) {

        for (int fila = 3; fila < tauler.length; fila++) {
            for (int col = tauler[0].length - 1; col > tauler[0].length - 5; col--) {
                if (connectaDiagonalEsquerra(fila, col, fitxa)) {
                    return true;
                }
            }
        }

        return false;
    }



    private boolean connectaDiagonalEsquerra(int fila, int columna, char fitxa) {

        CONTADOR_FITXES = 0;

        for (int i = 0; i < tauler.length - 2; i++) {
            if (esMateixaFitxa(tauler[fila - i][columna - i], fitxa)) {
                CONTADOR_FITXES++;
            }
        }
        return CONTADOR_FITXES == CONNECTA;
    }




    private boolean esMateixaFitxa(char casella, char fitxa) {
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


    //Getters
    public char[][] getTauler() {
        return tauler;
    }

    public static char getCasellaBuida() {
        return CASELLA_BUIDA;
    }
}

