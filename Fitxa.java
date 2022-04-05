package ProjecteConnecta4;

public class Fitxa {

    private int fitxes = 25; //NO ES NECESSARI
    private char fitxa;


    public Fitxa (char fitxa) {
        this.fitxa = fitxa;
    }


    public int getFitxes() {
        return fitxes;
    }

    public void restaFitxa(){
        this.fitxes -= 1;
    }

    public char getCaraFitxa() {
        return fitxa;
    }
}
