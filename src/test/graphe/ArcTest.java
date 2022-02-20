package graphe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcTest {
    private Sommet sommet1, sommet2,sommet3;
    private Arc arc1,arc2,arc3;
    @BeforeEach
    void setup() {
        sommet1 = new  Sommet("sommet1");
        sommet2 = new  Sommet("sommet2");
        sommet3 = new  Sommet("sommet1");
        arc1 = new Arc(sommet1,sommet2);
        arc2 = new Arc(sommet1,sommet3);
    }

    @Test
    void getSommetDepart() {
        assertEquals(arc1.getSommetDepart(),sommet1);
    }

    @Test
    void getSommetDestination() {
        assertEquals(arc1.getSommetDestination(),sommet2);
    }

    @Test
    void testEquals() {

    }
}