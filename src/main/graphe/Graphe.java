package graphe;

import java.util.Arrays;

public class Graphe implements IGraphe{

    private final static int NOMBRE_MAX_SOMMETS = 100;

    private int [][] matriceGraphe;
    private boolean [] etatPResenceSommet;


    public Graphe() {
        matriceGraphe = new int[NOMBRE_MAX_SOMMETS][NOMBRE_MAX_SOMMETS];
        Arrays.fill(matriceGraphe,0);
        etatPResenceSommet = new boolean[NOMBRE_MAX_SOMMETS];
        Arrays.fill(etatPResenceSommet,false);
    }
    @Override
    public void ajouterSommet(int numSommet) {
        //TODO Check if numSommet is in rang otherwise throw outof index exception
        // TODO check if numSommet is not alrealdy added, otherwise throw an exception
        etatPResenceSommet[numSommet] = true;
    }

    @Override
    public void supprimerSommet(int numSommet) {
        //TODO Check if numSommet is in rang otherwise throw outof index exception
        // TODO check if numSommet is alrealdy added, otherwise throw an exception
        etatPResenceSommet[numSommet] = false;
        detruireArcsSortantsEtArrivants(numSommet);
    }

    @Override
    public void creerArc(int numsommetDepart, int numSommetdestination) {
        // TODO Check if numSommet and numSommetdestination is in rang otherwise throw outof index exception
        // TODO check if numsommetDepart and  numSommetdestination is alrealdy added, otherwise throw an exception
        // TODO check that the arc does not alrealdy existe, otherwise throw an exception
        matriceGraphe[numsommetDepart][numSommetdestination ] = 1;
    }

    @Override
    public void detruireArc(int numsommetDepart, int numSommetdestination) {
        // TODO Check if numSommet and numSommetdestination is in rang otherwise throw outof index exception
        // TODO check if numsommetDepart and  numSommetdestination is alrealdy added, otherwise throw an exception
        // TODO check that the arc  alrealdy existe, otherwise throw an exception
        matriceGraphe[numsommetDepart][numSommetdestination ] = 0;
    }

    private void detruireArcsSortants(int numSommetDepart) {
        for(int i = 0; i < NOMBRE_MAX_SOMMETS; i++) {
            detruireArc(numSommetDepart,i);
        }
    }

    private void detruireArcsArrivants(int numSommetDestination) {
        for(int i = 0; i < NOMBRE_MAX_SOMMETS; i++) {
            detruireArc(i, numSommetDestination);
        }
    }

    private void detruireArcsSortantsEtArrivants(int numSommet) {
        detruireArcsSortants(numSommet);
        detruireArcsArrivants(numSommet);
    }

    @Override
    public String toString() {
        return "A faire";
    }
}
