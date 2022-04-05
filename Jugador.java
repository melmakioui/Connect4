package ProjecteConnecta4;

public class Jugador {

    private String nom;
    private boolean guanyador = false;
    private Fitxa fitxa;


    public Jugador(String nom) {
        this.nom = nom;
    }

    public Jugador(String nom, Fitxa fitxa) {
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
        return this.guanyador = true;
    }

    public Fitxa getFitxa() {
        return fitxa;
    }


    @Override
    public String toString() {
        return "Jugador{" +
                "nom='" + nom + '\'' +
                ", fitxa=" + fitxa.getCaraFitxa() +
                '}';
    }
}
