package com.vehiculemagique.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

public class VehiculeSteps {

    private final CucumberContext ctx;

    public VehiculeSteps(CucumberContext ctx) {
        this.ctx = ctx;
    }

    @When("je roule de {int} km")
    public void jeRouleDeKm(int km) {
        ctx.vehicule.ajouterKilometres(km);
    }

    @When("je tente de rouler de {int} km")
    public void jeTenteDeRoulerDeKm(int km) {
        try {
            ctx.vehicule.ajouterKilometres(km);
        } catch (Exception e) {
            ctx.derniereException = e;
        }
    }

    @Then("le kilometrage vaut {int}")
    public void leKilometrageVaut(int attendu) {
        assertEquals(attendu, ctx.vehicule.getKilometrage());
    }

    @Then("une exception IllegalArgumentException est levee")
    public void uneExceptionIllegalArgumentExceptionEstLevee() {
        assertNotNull(ctx.derniereException, "Une exception aurait dû être levée");
        assertTrue(ctx.derniereException instanceof IllegalArgumentException);
    }
}