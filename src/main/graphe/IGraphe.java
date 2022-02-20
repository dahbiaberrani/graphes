package graphe;

import java.util.Set;

public interface IGraphe {
    void ajouterSommet(Sommet sommet);
    void supprimerSommet(Sommet sommet);
    void creerArc(Sommet sommetDepart, Sommet sommetdestination);
    void detruireArc(Arc arc);
    void detruireArc(Sommet sommetDepart, Sommet sommetdestination);
    Set<Arc> getArcsIncidents(Sommet sommet);
    Set<Sommet> getSommetsVoisins(Sommet sommet);
    boolean rechercherChemin(Sommet sommetDepart , Sommet sommetDestination);
}
