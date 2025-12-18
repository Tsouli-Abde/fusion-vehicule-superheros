package com.dauphine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de tests unitaires pour SuperHeros
 */
public class SuperHerosTest {

    private SuperHeros spiderman;
    private Univers univers;

    /**
     * Constructeur par défaut
     */
    public SuperHerosTest() {
    }

    /**
     * Initialisation avant chaque test.
     * Crée un environnement propre (Spiderman dans Marvel)
     */
    @BeforeEach
    public void setUp() {
        spiderman = new SuperHeros("Spider Man", "Tisse des toiles");
        univers = new Univers("Marvel");
        spiderman.setUnivers(univers);
    }

    /**
     * Nettoyage après chaque test (vide ici, mais bonne pratique)
     */
    @AfterEach
    public void tearDown() {
    }


    @Test
    public void testModificationNom() {
        spiderman.setNom("Peter Parker");
        assertEquals("Peter Parker", spiderman.getNom());
    }

    @Test
    public void testNomUnivers() {
        assertEquals("Marvel", univers.getNom());
    }
    
    @Test
    public void testToString() {
        String description = spiderman.toString();
        assertTrue(description.contains("Spider Man"));
        assertTrue(description.contains("Marvel"));
    }

    @Test
    public void testAssociationBidirectionnelle() {
        Groupe avengers = new Groupe("Avengers");
        SuperHeros ironMan = new SuperHeros("Iron Man", "Armure High-Tech");

        avengers.ajouterMembre(ironMan);

        assertEquals(avengers, ironMan.getGroupe(), "Iron Man devrait savoir qu'il est chez les Avengers");
        assertTrue(avengers.getMembres().contains(ironMan), "Les Avengers devraient compter Iron Man dans leurs rangs");
    }

    @Test
    public void testTransfertHeros() {
        Groupe avengers = new Groupe("Avengers");
        Groupe justiceLeague = new Groupe("Justice League");
        
        spiderman.setGroupe(avengers);
        verifierHerosEstBienDansLeGroupe(spiderman, avengers);

        spiderman.setGroupe(justiceLeague);

        verifierHerosEstBienDansLeGroupe(spiderman, justiceLeague);
        verifierHerosNestPlusDansLeGroupe(spiderman, avengers);
    }

    private void verifierHerosEstBienDansLeGroupe(SuperHeros h, Groupe g) {
        assertEquals(g, h.getGroupe(), "Le héros " + h.getNom() + " devrait pointer vers le groupe " + g.getNom());
        assertTrue(g.getMembres().contains(h), "Le groupe " + g.getNom() + " devrait contenir " + h.getNom());
    }

    private void verifierHerosNestPlusDansLeGroupe(SuperHeros h, Groupe g) {
        assertFalse(g.getMembres().contains(h), "Le groupe " + g.getNom() + " ne devrait plus contenir " + h.getNom());
        if (h.getGroupe() == g) {
            fail("Le héros " + h.getNom() + " pointe toujours vers l'ancien groupe " + g.getNom());
        }
    }
    
    @Test
    public void testSuppressionMembre() {
        Groupe xmen = new Groupe("X-Men");
        SuperHeros wolverine = new SuperHeros("Wolverine", "Griffes en adamantium");
        
        xmen.ajouterMembre(wolverine);
        
        xmen.supprimerMembre(wolverine);
        
        assertFalse(xmen.getMembres().contains(wolverine), "Le groupe ne doit plus avoir le membre");
        assertNull(wolverine.getGroupe(), "Le héros ne devrait plus avoir de groupe");
    }
}
