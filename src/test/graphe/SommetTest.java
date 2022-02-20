package graphe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SommetTest {
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
    void getNom() {
        assertEquals(sommet1.getNom(),"sommet1");
    }

    @Test
    void testEquals() {
        assertFalse(sommet1.equals(sommet2));
        assertTrue(sommet1.equals(sommet1));
        assertTrue(sommet1.equals(sommet3));
    }
}