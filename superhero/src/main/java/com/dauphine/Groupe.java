package com.dauphine;

import java.util.ArrayList;
import java.util.List;

/**
 * Un groupe contient plusieurs super héros (Association One-To-Many)
 */
public class Groupe {
    private String nom;
    private List<SuperHeros> membres;

    public Groupe(String nom) {
        this.nom = nom;
        this.membres = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<SuperHeros> getMembres() {
        return membres;
    }

    /**
     * Ajoute un héros au groupe en assurant la cohérence bidirectionnelle.
     */
    public void ajouterMembre(SuperHeros hero) {
        if (hero != null && !this.membres.contains(hero)) {
            this.membres.add(hero);
            
            if (hero.getGroupe() != this) {
                hero.setGroupe(this);
            }
        }
    }

    /**
     * Retire un héros du groupe
     */
    public void supprimerMembre(SuperHeros hero) {
        if (this.membres.contains(hero)) {
            this.membres.remove(hero);
            
            if (hero.getGroupe() == this) {
                hero.setGroupe(null);
            }
        }
    }
}