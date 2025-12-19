package com.fusion.adapter;

import com.dauphine.SuperHeros;
import com.vehiculemagique.Proprietaire;
import com.vehiculemagique.Vehicule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroProprietaireAdapterTest {

    @Test
    void exposeUnProprietaireSynchroAvecLeHero() {
        SuperHeros hero = new SuperHeros("Wonder Woman", "protège la Terre");
        HeroProprietaireAdapter adapter = new HeroProprietaireAdapter(hero);

        assertSame(hero, adapter.getHero());

        Proprietaire proprietaire = adapter.asProprietaire();
        assertEquals("Wonder Woman", proprietaire.getNom());
    }

    @Test
    void assignerVehiculeMetAJourLesDeuxUnivers() {
        SuperHeros hero = new SuperHeros("Green Lantern", "forge des constructs");
        HeroProprietaireAdapter adapter = new HeroProprietaireAdapter(hero);
        Vehicule vehicule = new Vehicule("GL-2814");

        adapter.assignerVehicule(vehicule);

        assertSame(adapter.asProprietaire(), vehicule.getProprietaire());
        assertTrue(adapter.asProprietaire().getVehicules().contains(vehicule));
    }

    @Test
    void calculerAssuranceDelegueAuModeleVehicule() {
        SuperHeros hero = new SuperHeros("Flash", "super vitesse");
        HeroProprietaireAdapter adapter = new HeroProprietaireAdapter(hero);
        Vehicule vehicule = new Vehicule("FLS-90");
        vehicule.setKilometrage(1500);

        adapter.assignerVehicule(vehicule);
        int assurance = adapter.calculerAssurance(vehicule);

        assertEquals(301, assurance);
    }
}
