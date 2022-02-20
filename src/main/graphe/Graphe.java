package graphe;

import java.util.HashSet;
import java.util.Set;

public class Graphe implements IGraphe{

    private Set<Sommet> ensembleSommets;
    private Set<Arc> ensembleArcs;

    public Graphe() {
        ensembleSommets = new HashSet<>();
        ensembleArcs = new HashSet<>();
    }

    @Override
    public void ajouterSommet(Sommet sommet) {
        ensembleSommets.add(sommet);
    }

    @Override
    public void supprimerSommet(Sommet sommet) {
        ensembleSommets.remove(sommet);
        //TODO detruireArcsSortantsEtArrivants(sommet);
    }

    @Override
    public void creerArc(Sommet sommetDepart, Sommet sommetDestination) {
        ensembleArcs.add(new Arc(sommetDepart, sommetDestination));
    }

    @Override
    public void detruireArc(Sommet sommetDepart, Sommet sommetdestination) {
        ensembleArcs.remove(new Arc(sommetDepart,sommetdestination));
    }


    @Override
    public Set<Arc> getArcsIncidents(Sommet sommet) {
        Set<Arc> arcsIncidents = new HashSet<>();
        for (Arc arc : ensembleArcs) {
            if (arc.getSommetDestination().equals(sommet)) {
                arcsIncidents.add(arc);
            }
        }
        return arcsIncidents;
    }

    public boolean rechercherChemin(Sommet sommetDepart , Sommet sommetDestination) {
        if (sommetDepart.equals(sommetDestination)) {

            return true;
        }
        for (Sommet sommet : getSommetsVoisins(sommetDepart)) {
            if(sommetDepart.equals(sommetDestination)) {
                return true;
            }
            if(rechercherChemin(sommet, sommetDestination)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Sommet> getSommetsVoisins(Sommet sommet) {
        Set<Sommet> sommetsVoisins = new HashSet<>();

        for (Arc arc : ensembleArcs) {
            if (arc.getSommetDepart().equals(sommet)) {
                sommetsVoisins.add(arc.getSommetDestination());
            }
        }
        return sommetsVoisins;
    }

    @Override
    public void detruireArc(Arc arc) {
        ensembleArcs.remove(arc);
    }

//    private void detruireArcsSortants(int numSommetDepart) {
//        for(int i = 0; i < NOMBRE_MAX_SOMMETS; i++) {
//            detruireArc(numSommetDepart,i);
//        }
//    }
//
//    private void detruireArcsArrivants(int numSommetDestination) {
//        for(int i = 0; i < NOMBRE_MAX_SOMMETS; i++) {
//            detruireArc(i, numSommetDestination);
//        }
//    }
//
//    private void detruireArcsSortantsEtArrivants(int numSommet) {
//        detruireArcsSortants(numSommet);
//        detruireArcsArrivants(numSommet);
//    }

    @Override
    public String toString() {
        return this.ensembleSommets + "\n" + this.ensembleArcs;
    }

}
