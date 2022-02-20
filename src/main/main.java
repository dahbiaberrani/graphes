import graphe.Graphe;
import graphe.Sommet;
public class main {
    public static void main(String[] args) {
        // Creation du graphe
        Sommet s1 = new Sommet("s1");
        Sommet s2 = new Sommet("s2");
        Sommet s3 = new Sommet("s3");
        Sommet s4 = new Sommet("s4");

        Graphe graphe1 = new Graphe();
        Graphe graphe2 = new Graphe();
        graphe1.ajouterSommet(s1);
        graphe1.ajouterSommet(s2);
        graphe1.ajouterSommet(s3);
        graphe1.ajouterSommet(s4);


        graphe1.creerArc(s1, s2);
        graphe1.creerArc(s2, s3);
        graphe1.creerArc(s3, s4);

        System.out.println("Sommet: " + s1);

        System.out.println("Graphe1:" + graphe1);
        System.out.println("Chemin s1 à s4 dans graphe1: " + graphe1.rechercherChemin(s1,s4));
        System.out.println("Chemin s4 à s1 dans graphe1: " + graphe1.rechercherChemin(s4,s1));
        System.out.println("Chemin s1 à s3 dans graphe1: " + graphe1.rechercherChemin(s1,s3));
        System.out.println("Chemin s1 à s2 dans graphe1: " + graphe1.rechercherChemin(s1,s2));
        System.out.println("Chemin s1 à s1 dans graphe1: " + graphe1.rechercherChemin(s1,s1));

        System.out.println("Graphe2 (vide):" + graphe2);
        System.out.println("Chemin s1 à s4 dans graphe2 (vide): " + graphe2.rechercherChemin(s1,s4));
        System.out.println("Graphe 1 est connexe?: " + graphe1.estConnexe());
        System.out.println("Graphe 2 est connexe?: " + graphe2.estConnexe());
        graphe2.ajouterSommet(s1);
        System.out.println("Graphe 2 est connexe?: " + graphe2.estConnexe());
        // Rendre graphe1 connexe
        graphe1.creerArc(s4, s1);
        System.out.println("Graphe 1 est connexe?: " + graphe1.estConnexe());

        graphe1.supprimerSommet(s1);
        System.out.println("Graphe1:" + graphe1);
        graphe1.supprimerSommet(s2);
        System.out.println("Graphe1:" + graphe1);
    }
}
