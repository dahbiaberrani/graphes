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
}
