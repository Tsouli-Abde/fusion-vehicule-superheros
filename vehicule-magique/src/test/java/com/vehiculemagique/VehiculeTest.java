
package com.vehiculemagique;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class VehiculeTest {

    private Vehicule vehicule;
    private Proprietaire proprietaire;

    @BeforeEach
    void setUp() {
        vehicule = new Vehicule("AA-123-BB");
        proprietaire = new Proprietaire("Lilia");
        vehicule.setProprietaire(proprietaire);
    }

    @Test
    void vehiculeEstInitialiseAvecZeroKilometres() {
        assertEquals("AA-123-BB", vehicule.getImmatriculation());
        assertEquals(0, vehicule.getKilometrage());
    }

    @Test
    void roulerIncrementeLeKilometrage() {
        vehicule.ajouterKilometres(100);
        vehicule.ajouterKilometres(50);

        assertEquals(150, vehicule.getKilometrage());
    }

    @Test
    void roulerDistanceNegativeLeveUneException() {
        assertThrows(IllegalArgumentException.class, () -> vehicule.ajouterKilometres(-10));
    }

    @Test
    void peutModifierLImmatriculation() {
        vehicule.setImmatriculation("BB-456-CC");
        assertEquals("BB-456-CC", vehicule.getImmatriculation());
    }

    @Test
    void calculAssuranceUtiliseLeKilometrageDuVehicule() {
        vehicule.ajouterKilometres(2500);
        assertEquals(302, proprietaire.calculerAssuranceAnnuelle(vehicule));
    }
}
