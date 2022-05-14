package ProjecteConnecta4;

public class Jugador {

    private String nom;
    private boolean guanyador = false;
    private char fitxa;

    public Jugador(String nom, char fitxa) {
        this.nom = nom;
        this.fitxa = fitxa;
    }


    public String getNom() {
        return nom;
    }

    public boolean esGuanyador() {
        return guanyador;
    }

    public boolean haGuanyat(boolean guanyador) {
        return this.guanyador = guanyador;
    }

    public char getFitxa() {
        return fitxa;
    }

}
