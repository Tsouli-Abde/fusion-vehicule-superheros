package com.vehiculemagique;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProprietaireVehiculeAssociationTest {

    @Test
    public void testAjoutBidirectionnel() {
        Proprietaire p = new Proprietaire("Lilia");
        Vehicule v = new Vehicule("AA-123-BB");

        p.ajouterVehicule(v);

        assertEquals(p, v.getProprietaire());
        assertTrue(p.getVehicules().contains(v));
    }

    @Test
    public void testRetraitBidirectionnel() {
        Proprietaire p = new Proprietaire("Lilia");
        Vehicule v = new Vehicule("AA-123-BB");
        p.ajouterVehicule(v);

        p.retirerVehicule(v);

        assertNull(v.getProprietaire());
        assertFalse(p.getVehicules().contains(v));
    }

    @Test
    public void testTransfertProprietaireRobuste() {
        Proprietaire p1 = new Proprietaire("Lilia");
        Proprietaire p2 = new Proprietaire("Omar");
        Vehicule v = new Vehicule("AA-123-BB");

        p1.ajouterVehicule(v);
        p2.ajouterVehicule(v); // transfert

        assertEquals(p2, v.getProprietaire());
        assertFalse(p1.getVehicules().contains(v));
        assertTrue(p2.getVehicules().contains(v));
    }

    @Test
    public void testPasDeDoublonDansLaListe() {
        Proprietaire p = new Proprietaire("Lilia");
        Vehicule v = new Vehicule("AA-123-BB");

        p.ajouterVehicule(v);
        p.ajouterVehicule(v);

        assertEquals(1, p.getVehicules().size());
    }

    @Test
    public void testListeNonModifiable() {
        Proprietaire p = new Proprietaire("Lilia");
        assertThrows(UnsupportedOperationException.class, () -> {
            p.getVehicules().add(new Vehicule("ZZ-999-ZZ"));
        });
    }
}