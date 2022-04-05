package ProjecteConnecta4;

public class Jugador {

    private String nom;
    private boolean guanyador = false;




    public Jugador(String nom) {
        this.nom = nom;
    }


    public String getNom() {
        return nom;
    }

    public boolean esGuanyador() {
        return guanyador;
    }


}
