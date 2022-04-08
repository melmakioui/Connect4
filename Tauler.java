package ProjecteConnecta4;

public class Tauler {

    private char[][] tauler;
    private static final int CONNECTA = 4;
    private static final char CASELLA_BUIDA = '*';

    public Tauler() {
        this.tauler = new char[7][8];

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
                || comprovaEnDiagonalDreta(fila, columna, fitxa); //Falten dues en diagonal

    }


    private int colocaFitxa(int pos, char fitxa) {

        int fila = tauler.length - 1;
        int columna = pos;

        if (!estaBuida(fila,columna)) { //SI POSICIO ESTA OCUPADA -- METODE

            for (int i = fila; i > -1; i--) {
                if (estaBuida(i,columna)) {
                    tauler[i][columna] = fitxa;
                    return i;
                }
            }
        }

        tauler[fila][pos] = fitxa;

        return fila;
    }


    private boolean estaBuida(int fila, int columna) {
        return tauler[fila][columna] == CASELLA_BUIDA;
    }


    private boolean comprovaEnVertical(int fila, int col, char fitxa) {

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


    private boolean comprovaEnHorizontal(int fila, int col, char fitxa) {

        int contador = 0;

        //ESQUERRA <--
        for (int i = col; i > -1; i--) {
            if (tauler[fila][i] != fitxa) { //REFACTORITZAR
                break;
            } else contador++;
        }

        if (contador == CONNECTA)
            return true;


        //DRETA -->
        for (int j = col + 1; j < tauler[0].length; j++) {
            if (tauler[fila][j] != fitxa) {
                break;
            } else contador++;

        }

        return contador == CONNECTA;
    }


    private boolean comprovaEnDiagonalDreta(int fila, int col, char fitxa) {

        int contador = 0;


        for (int i = fila; i > -1; i--) {
            for (int j = col; j < tauler[0].length; j++) {

                if (tauler[i][j] != fitxa) {
                    contador = 0;
                    i = 0;
                    break; //metodo nuevo
                } else {
                    i--;
                    contador++;
                }
            }
        }

        if (contador == CONNECTA) {
            return true;
        }

        if (fila == tauler.length - 1 || col == 0) {
            return false;
        }

        //Array out of bounds
        for (int i = fila; i < tauler.length; ) {
            for (int j = col; j > 0 ; j--) {

                if (tauler[i][j] != fitxa) {
                    i = tauler.length - 1;
                    break;
                } else {
                    i++;
                    contador++;
                }
            }
        }

        return contador == CONNECTA;
    }


    public void imprimirTaula() {

        for (int i = 0; i < tauler.length; i++) {
            for (int j = 0; j < tauler[0].length; j++) {
                System.out.print(tauler[i][j] + "   ");
            }
            System.out.println();
        }
    }

}
