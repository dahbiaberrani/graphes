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

    @Override
    public int hashCode() {
        return this.nom.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Sommet sommet)) {
            return false;
        }
        return this.nom.equals(sommet.nom);
    }
}
