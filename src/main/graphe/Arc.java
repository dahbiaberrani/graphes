package graphe;

public class Arc {
    private Sommet sommetDepart;
    private Sommet sommetDestination;


    public Arc(Sommet sommetDepart, Sommet sommetDestination) {
        this.sommetDepart = sommetDepart;
        this.sommetDestination = sommetDestination;
    }

    public Sommet getSommetDepart() {
        return sommetDepart;
    }

    public Sommet getSommetDestination() {
        return sommetDestination;
    }

    @Override
    public String toString() {
        return sommetDepart.toString() + "->" + sommetDestination.toString();
    }

    @Override
    public int hashCode() {
        return this.sommetDepart.hashCode() + this.sommetDestination.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Arc arc)) {
            return false;
        }
        return this.sommetDepart.equals(arc.sommetDepart) && this.sommetDestination.equals(arc.sommetDestination);
    }
}
