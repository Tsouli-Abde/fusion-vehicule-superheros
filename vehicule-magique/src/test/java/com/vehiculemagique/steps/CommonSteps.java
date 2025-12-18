package com.vehiculemagique.steps;

import com.vehiculemagique.Proprietaire;
import com.vehiculemagique.Vehicule;
import io.cucumber.java.en.Given;

public class CommonSteps {

    private final CucumberContext ctx;

    public CommonSteps(CucumberContext ctx) {
        this.ctx = ctx;
    }

    @Given("un vehicule immatricule {string} avec un kilometrage initial {int}")
    public void unVehiculeImmatriculeAvecUnKilometrageInitial(String immat, int km) {
        ctx.vehicule = new Vehicule(immat);
        ctx.vehicule.setKilometrage(km);
        ctx.derniereException = null;
    }

    @Given("un proprietaire nomme {string}")
    public void unProprietaireNomme(String nom) {
        ctx.proprietaire = new Proprietaire(nom);
    }
}