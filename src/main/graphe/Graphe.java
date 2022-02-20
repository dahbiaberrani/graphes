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
        //Suppressions des arcs incidents et partants de ce sommet
        detruireArcsSortantsEtArrivants(sommet);
        //Suppression du sommet
        ensembleSommets.remove(sommet);

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

    public Set<Arc> rechercherChemin(Sommet sommetDepart , Sommet sommetDestination) {
        Set<Arc> chemin = new HashSet<>();
        Arc arc = new Arc(sommetDepart, sommetDestination);
        if (this.ensembleArcs.contains(arc)) {
            chemin.add(arc);
            return chemin;
        }
        for (Sommet sommet : getSommetsVoisins(sommetDepart)) {
            Set<Arc> cheminPartiel = rechercherChemin(sommet, sommetDestination);
            if(!cheminPartiel.isEmpty()) {
                chemin.add(new Arc(sommetDepart, sommet));
                chemin.addAll(cheminPartiel);
                return chemin;
            }
        }
        return chemin;
    }

    @Override
    public boolean estConnexe() {
        for(Sommet sommet1 : this.ensembleSommets) {
            for(Sommet sommet2: this.ensembleSommets) {
                if (!sommet1.equals(sommet2)) {
                    if (rechercherChemin(sommet1,sommet2).isEmpty()) {
                        return false;
                    }
                }
            }
        }
        return true;
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


    private void detruireArcsSortantsEtArrivants(Sommet sommet) {
        HashSet<Arc> arcASupprimer = new HashSet<>();
        for(Arc arc : this.ensembleArcs) {
            if(arc.getSommetDestination().equals(sommet) || arc.getSommetDepart().equals(sommet)) {
                arcASupprimer.add(arc);
            }
        }

        for(Arc arc : arcASupprimer) {
            this.ensembleArcs.remove(arc);
        }
    }

    @Override
    public String toString() {
        return "Sommets: " + this.ensembleSommets + "\n" + "Arcs: " + this.ensembleArcs;
    }

}
