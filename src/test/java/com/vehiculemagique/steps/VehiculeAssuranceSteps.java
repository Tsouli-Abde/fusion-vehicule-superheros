package com.vehiculemagique.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehiculeAssuranceSteps {

    private final CucumberContext ctx;

    public VehiculeAssuranceSteps(CucumberContext ctx) {
        this.ctx = ctx;
    }

    @When("je calcule l assurance du vehicule")
    public void jeCalculeLAssuranceDuVehicule() {
        ctx.coutAssurance = ctx.proprietaire.calculerAssuranceAnnuelle(ctx.vehicule);
    }

    @Then("le cout de l assurance vaut {int}")
    public void leCoutDeLAssuranceVaut(int attendu) {
        assertEquals(attendu, ctx.coutAssurance);
    }
}