package com.fusion.facade.steps;

import com.dauphine.SuperHeros;
import com.fusion.adapter.HeroProprietaireAdapter;
import com.vehiculemagique.Vehicule;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.*;

public class AdapterSteps {

    private SuperHeros hero;
    private HeroProprietaireAdapter adapter;
    private Vehicule vehicule;

    @Given("un super héros nommé {string} avec le pouvoir {string}")
    public void unSuperHerosNommeAvecLePouvoir(String nom, String pouvoir) {
        this.hero = new SuperHeros(nom, pouvoir);
    }

    @Given("un véhicule immatriculé {string} avec {int} km au compteur")
    public void unVehiculeImmatriculeAvecKmAuCompteur(String immat, int km) {
        this.vehicule = new Vehicule(immat);
        this.vehicule.setKilometrage(km);
    }

    @Given("un véhicule immatriculé {string}")
    public void unVehiculeImmatricule(String immat) {
        this.vehicule = new Vehicule(immat);
    }

    @When("je crée un adaptateur pour ce héros")
    public void jeCreeUnAdaptateurPourCeHeros() {
        this.adapter = new HeroProprietaireAdapter(this.hero);
    }

    @When("j'assigne le véhicule au héros via l'adaptateur")
    public void jAssigneLeVehiculeAuHerosViaLAdaptateur() {
        this.adapter.assignerVehicule(this.vehicule);
    }

    @Then("l'adaptateur doit exposer un propriétaire nommé {string}")
    public void lAdaptateurDoitExposerUnProprietaireNomme(String nomAttendu) {
        assertEquals(nomAttendu, this.adapter.asProprietaire().getNom());
    }

    @Then("le véhicule doit avoir pour propriétaire {string}")
    public void leVehiculeDoitAvoirPourProprietaire(String nomAttendu) {
        assertNotNull(this.vehicule.getProprietaire());
        assertEquals(nomAttendu, this.vehicule.getProprietaire().getNom());
    }

    @Then("la liste des véhicules de l'adaptateur doit contenir {string}")
    public void laListeDesVehiculesDeLAdaptateurDoitContenir(String immat) {
        boolean contient = this.adapter.asProprietaire().getVehicules().stream()
                .anyMatch(v -> v.getImmatriculation().equals(immat));
        assertTrue(contient);
    }

    @Then("le coût d'assurance calculé par l'adaptateur doit être {int}")
    public void leCoutDAssuranceCalculeParLAdaptateurDoitEtre(int montantAttendu) {
        assertEquals(montantAttendu, this.adapter.calculerAssurance(this.vehicule));
    }
}