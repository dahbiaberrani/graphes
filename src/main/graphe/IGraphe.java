package graphe;
public interface IGraphe {
    void ajouterSommet(int numSommet);
    void supprimerSommet(int numSommet);
    void creerArc(int numsommetDepart, int numSommetdestination);
    void detruireArc(int numsommetDepart, int numSommetdestination);

}
