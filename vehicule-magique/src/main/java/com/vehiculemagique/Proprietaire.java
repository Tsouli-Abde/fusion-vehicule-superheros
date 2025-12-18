package com.vehiculemagique;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Proprietaire {

    private String nom;
    private List<Vehicule> vehicules;

    public Proprietaire(String nom) {
        this.nom = nom;
        this.vehicules = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Vehicule> getVehicules() {
        return Collections.unmodifiableList(vehicules);
    }

    //encapsulation
    public void ajouterVehicule(Vehicule v) {
        if (v == null)
            throw new IllegalArgumentException("vehicule null");
        v.setProprietaire(this); // centralise la cohérence
    }

    public void retirerVehicule(Vehicule v) {
        if (v == null)
            return;
        if (v.getProprietaire() != this)
            return;
        v.setProprietaire(null); // centralise la cohérence
    }

    // Méthodes internes appelées par Vehicule.setProprietaire pour éviter les boucles
    void _ajouterVehicule(Vehicule v) {
        if (!vehicules.contains(v))
            vehicules.add(v);
    }

    void _retirerVehicule(Vehicule v) {
        vehicules.remove(v);
    }

    public int calculerAssuranceAnnuelle(Vehicule v) {
        return 300 + calculerSurcoutKilometrique(v);
    }

    private int calculerSurcoutKilometrique(Vehicule v) {
        return v.getKilometrage() / 1000;
    }

}