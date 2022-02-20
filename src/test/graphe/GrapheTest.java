package graphe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrapheTest {
    private Sommet s1, s2, s3, s4;
    private  Graphe graphe1, graphe2;
    @BeforeEach
    void setUp() {
        // Creation du graphe
        s1 = new Sommet("s1");
        s2 = new Sommet("s2");
        s3 = new Sommet("s3");
        s4 = new Sommet("s4");

        graphe1 = new Graphe();
        graphe2 = new Graphe();

        graphe1.ajouterSommet(s2);
        graphe1.ajouterSommet(s3);
        graphe1.ajouterSommet(s1);


        graphe1.creerArc(s1, s2);
        graphe1.creerArc(s2, s3);

    }
    @Test
    void ajouterSommet() {
        assertTrue(graphe1.getEnsembleSommets().contains(s1));
        assertTrue(graphe1.getEnsembleSommets().contains(s2));
        assertTrue(graphe1.getEnsembleSommets().contains(s3));
        assertFalse(graphe1.getEnsembleSommets().contains(s4));
        graphe1.ajouterSommet(s4);
        assertTrue(graphe1.getEnsembleSommets().contains(s4));
    }

    @Test
    void supprimerSommet() {
        assertTrue(graphe1.getEnsembleSommets().contains(s1));
        graphe1.supprimerSommet((s1));
        assertFalse(graphe1.getEnsembleSommets().contains(s1));
    }

    @Test
    void creerArc() {
        assertTrue(graphe1.getEnsembleArcs().contains(new Arc(s1, s2)));
        assertTrue(graphe1.getEnsembleArcs().contains(new Arc(s2, s3)));
        assertFalse(graphe1.getEnsembleArcs().contains(new Arc(s3, s4)));
        graphe1.creerArc(s3, s4);
        assertTrue(graphe1.getEnsembleArcs().contains(new Arc(s3, s4)));
    }

    @Test
    void detruireArc() {
        assertTrue(graphe1.getEnsembleArcs().contains(new Arc(s1, s2)));
        assertTrue(graphe1.getEnsembleArcs().contains(new Arc(s2, s3)));
        assertFalse(graphe1.getEnsembleArcs().contains(new Arc(s3, s4)));
        graphe1.detruireArc(s1, s2);
        assertFalse(graphe1.getEnsembleArcs().contains(new Arc(s1, s2)));
    }

    @Test
    void getArcsIncidents() {

        assertEquals(0, graphe1.getArcsIncidents(s1).size());
        assertEquals(1, graphe1.getArcsIncidents(s2).size());
    }

    @Test
    void rechercherChemin() {
        assertEquals(0, graphe1.rechercherChemin(s1, s4).size());
        assertEquals(2, graphe1.rechercherChemin(s1, s3).size());
        assertEquals(1, graphe1.rechercherChemin(s1, s2).size());
        assertEquals(0, graphe1.rechercherChemin(s1, s1).size());
    }

    @Test
    void estConnexe() {
        assertFalse(graphe1.estConnexe());

        //Graphe vide est connexe
        assertTrue(graphe2.estConnexe());

        // Graphe avec un seul sommet est connexe
        graphe2.ajouterSommet(s3);
        assertTrue(graphe2.estConnexe());

        // On va rendre graphe1 connexe
        graphe1.creerArc(s3, s4);
        graphe1.creerArc(s4, s1);
        assertTrue(graphe1.estConnexe());

    }
}