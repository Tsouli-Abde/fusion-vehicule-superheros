package com.fusion.facade;

import com.dauphine.SuperHeros;
import com.dauphine.Univers;
import com.vehiculemagique.Vehicule;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {

    @Test
    void facadeAssocieHeroEtVehiculeEtCalculeAssurance() {
        SuperHeros hero = new SuperHeros("Batman", "protège Gotham");
        hero.setUnivers(new Univers("DC"));
        Vehicule vehicule = new Vehicule("BAT-001");

        Garage facade = new Garage();
        Garage.Session session = facade.fusionner(hero, vehicule);

        session.enregistrerMission(150);
        assertEquals(150, session.getVehicule().getKilometrage());

        assertEquals(300, session.coutAssurance());

        String presentation = session.presentation();
        assertTrue(presentation.contains("Batman"));
        assertTrue(presentation.contains("BAT-001"));
        assertTrue(presentation.contains("DC"));
    }
}
