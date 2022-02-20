package graphe;

public class Sommet {
    private String nom;

    public Sommet(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "(" + this.nom + ")";
    }
}
