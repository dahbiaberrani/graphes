import graphe.Arc;
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
        graphe1.ajouterSommet(s1);
        graphe1.ajouterSommet(s2);
        graphe1.ajouterSommet(s3);
        graphe1.ajouterSommet(s4);

        Arc arc1 = new Arc(s1, s2);
        Arc arc2 = new Arc(s2,s3);
        Arc arc3 = new Arc(s3,s4);

        graphe1.creerArc(s1, s2);
        graphe1.creerArc(s2, s3);
        graphe1.creerArc(s3, s4);

        System.out.println(s1);
        System.out.println(arc1);
        System.out.println(graphe1);
        System.out.println(graphe1.rechercherChemin(s1,s4));
        System.out.println(graphe1.rechercherChemin(s4,s1));
    }
}
