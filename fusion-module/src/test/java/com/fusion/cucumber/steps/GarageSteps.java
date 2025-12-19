package com.fusion.facade.steps;

import com.dauphine.SuperHeros;
import com.dauphine.Univers;
import com.fusion.facade.Garage;
import com.vehiculemagique.Vehicule;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

public class GarageSteps {

    private SuperHeros hero;
    private Vehicule vehicule;
    private Garage.Session session;

    @Given("un super héros {string} avec le pouvoir {string} dans l'univers {string}")
    public void creerHero(String nom, String pouvoir, String univers) {
        hero = new SuperHeros(nom, pouvoir);
        hero.setUnivers(new Univers(univers));
    }

    @And("un véhicule magique immatriculé {string}")
    public void creerVehicule(String immat) {
        vehicule = new Vehicule(immat);
    }

    @When("j'associe le héros au véhicule via la façade")
    public void associerAvecFacade() {
        Garage facade = new Garage();
        session = facade.fusionner(hero, vehicule);
    }

    @And("j'enregistre une mission de {int} km")
    public void enregistrerMission(int km) {
        session.enregistrerMission(km);
    }

    @Then("le kilométrage du véhicule vaut {int}")
    public void verifierKilometrage(int attendu) {
        assertNotNull(session);
        assertEquals(attendu, session.getVehicule().getKilometrage());
    }

    @Then("le coût d'assurance estimé est {int}")
    public void verifierAssurance(int cout) {
        assertEquals(cout, session.coutAssurance());
    }

    @Then("le message fusionné contient {string} et {string}")
    public void verifierMessage(String nomHero, String immat) {
        String presentation = session.presentation();
        assertTrue(presentation.contains(nomHero));
        assertTrue(presentation.contains(immat));
    }
}
