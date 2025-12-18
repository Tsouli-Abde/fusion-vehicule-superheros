package com.fusion.adapter;

import com.dauphine.SuperHeros;
import com.vehiculemagique.Proprietaire;
import com.vehiculemagique.Vehicule;

/**
 * Adapter qui expose un {@link SuperHeros} comme un {@link Proprietaire} du
 * projet "vehicule-magique" sans modifier les codes sources existants.
 * <p>
 * L'adapter encapsule la logique de synchronisation : le nom du héros est
 * projeté vers le propriétaire utilisé côté véhicule et toutes les opérations
 * critiques (ajout d'un véhicule, calcul d'assurance) sont déléguées au modèle
 * "vehicule-magique".
 */
public class HeroProprietaireAdapter {

    private final SuperHeros hero;
    private final Proprietaire proprietaire;

    public HeroProprietaireAdapter(SuperHeros hero) {
        this.hero = hero;
        this.proprietaire = new Proprietaire(hero.getNom());
    }

    /** Retourne la vue super-héros (projet "superheros"). */
    public SuperHeros getHero() {
        return hero;
    }

    /** Retourne la vue propriétaire (projet "vehicule-magique"). */
    public Proprietaire asProprietaire() {
        return proprietaire;
    }

    /**
     * Confie un véhicule magique au héros.
     */
    public void assignerVehicule(Vehicule vehicule) {
        proprietaire.ajouterVehicule(vehicule);
    }

    /**
     * Calcule l'assurance annuelle en réutilisant les règles du projet
     * "vehicule-magique".
     */
    public int calculerAssurance(Vehicule vehicule) {
        return proprietaire.calculerAssuranceAnnuelle(vehicule);
    }

    /**
     * Construit une description textuelle fusionnant les deux univers.
     */
    public String description(Vehicule vehicule) {
        String base = hero.toString();
        String proprietaireNom = proprietaire.getNom();
        return base + " et je pilote le vehicule " + vehicule.getImmatriculation()
                + " en tant que proprietaire " + proprietaireNom;
    }
}
