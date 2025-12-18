package com.dauphine;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperHeroSteps {

    private SuperHeros heros;
    private Univers univers;
    private String reponseToString;

    // --- US-001 : Création basique ---
    
    @Given("un nom {string} et un pouvoir {string}")
    public void un_nom_et_un_pouvoir(String nom, String pouvoir) {
        this.heros = new SuperHeros(nom, pouvoir);
    }

    @Given("un super héros nommé {string}")
    public void un_super_heros_nomme(String nom) {
        this.heros = new SuperHeros(nom, "Inconnu");
    }

    @When("je crée le super héros")
    public void je_cree_le_super_heros() {

    }

    @Then("le héros doit s'appeler {string}")
    public void le_heros_doit_s_appeler(String nomAttendu) {
        assertEquals(nomAttendu, this.heros.getNom());
    }

    @Then("son pouvoir doit être {string}")
    public void son_pouvoir_doit_etre(String pouvoirAttendu) {
        assertEquals(pouvoirAttendu, this.heros.getPouvoir());
    }

    // --- US-001 (Correction) ---

    @Given("un super héros initial nommé {string}")
    public void un_super_heros_initial_nomme(String nom) {
        this.heros = new SuperHeros(nom, "Défaut");
    }

    @When("je corrige son nom par {string}")
    public void je_corrige_son_nom_par(String nouveauNom) {
        this.heros.setNom(nouveauNom);
    }

    @When("je corrige son pouvoir par {string}")
    public void je_corrige_son_pouvoir_par(String nouveauPouvoir) {
        this.heros.setPouvoir(nouveauPouvoir);
    }

    // --- US-002 : Univers ---

    @Given("un super héros nommé {string} existe")
    public void un_super_heros_nomme_existe(String nom) {
        this.heros = new SuperHeros(nom, "SuperForce");
    }

    @Given("un univers nommé {string} existe")
    public void un_univers_nomme_existe(String nomUnivers) {
        this.univers = new Univers(nomUnivers);
    }

    @When("j'affecte le héros à l'univers {string}")
    public void j_affecte_le_heros_a_l_univers(String nomUnivers) {
        if (!this.univers.getNom().equals(nomUnivers)) {
             this.univers = new Univers(nomUnivers);
        }
        this.heros.setUnivers(this.univers);
    }

    @Then("l'univers du héros doit être {string}")
    public void l_univers_du_heros_doit_etre(String universAttendu) {
        assertEquals(universAttendu, this.heros.getUnivers().getNom());
    }
    
    @Given("un héros {string} déjà dans l'univers {string}")
    public void un_heros_deja_dans_l_univers(String nomHeros, String nomUnivers) {
        this.heros = new SuperHeros(nomHeros, "Standard");
        this.univers = new Univers(nomUnivers);
        this.heros.setUnivers(this.univers);
    }

    @When("je transfère le héros vers l'univers {string}")
    public void je_transfere_le_heros_vers_l_univers(String nouvelUnivers) {
        Univers u = new Univers(nouvelUnivers);
        this.heros.setUnivers(u);
    }

    // --- US-003 : Affichage ---

    @Given("un héros nommé {string} avec le pouvoir {string}")
    public void un_heros_nomme_avec_le_pouvoir(String nom, String pouvoir) {
        this.heros = new SuperHeros(nom, pouvoir);
    }

    @Given("le héros appartient à l'univers {string}")
    public void le_heros_appartient_a_l_univers(String nomUnivers) {
        this.univers = new Univers(nomUnivers);
        this.heros.setUnivers(this.univers);
    }

    @When("je demande son identité")
    public void je_demande_son_identite() {
        this.reponseToString = this.heros.toString();
    }

    @Then("la phrase renvoyée doit être exactement {string}")
    public void la_phrase_renvoyee_doit_etre_exactement(String phraseAttendue) {
        assertEquals(phraseAttendue, this.reponseToString);
    }
}
