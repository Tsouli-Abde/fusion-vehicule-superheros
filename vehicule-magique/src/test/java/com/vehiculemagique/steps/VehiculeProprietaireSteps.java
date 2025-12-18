package com.vehiculemagique.steps;

import com.vehiculemagique.Vehicule;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculeProprietaireSteps {

    private final CucumberContext ctx;

    public VehiculeProprietaireSteps(CucumberContext ctx) {
        this.ctx = ctx;
    }

    @Given("un vehicule immatricule {string} sans proprietaire")
    public void unVehiculeImmatriculeSansProprietaire(String immat) {
        ctx.vehicule = new Vehicule(immat);
        ctx.derniereException = null;
        ctx.proprietaire = null;
    }

    @When("j associe le proprietaire au vehicule")
    public void jAssocieLeProprietaireAuVehicule() {
        ctx.vehicule.setProprietaire(ctx.proprietaire);
    }

    @Then("le proprietaire du vehicule est {string}")
    public void leProprietaireDuVehiculeEst(String nom) {
        assertNotNull(ctx.vehicule.getProprietaire());
        assertEquals(nom, ctx.vehicule.getProprietaire().getNom());
    }

    @Then("le vehicule n a pas de proprietaire")
    public void leVehiculeNaPasDeProprietaire() {
        assertNull(ctx.vehicule.getProprietaire());
    }
}