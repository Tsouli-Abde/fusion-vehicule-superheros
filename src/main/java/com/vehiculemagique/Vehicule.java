package com.vehiculemagique;

public class Vehicule {

    private String immatriculation;
    private int kilometrage;

    private Proprietaire proprietaire;

    public Vehicule(String immatriculation) {
        this.immatriculation = immatriculation;
        this.kilometrage = 0;
        this.proprietaire = null;
    }

    public String getImmatriculation() { return immatriculation; }
    public void setImmatriculation(String immatriculation) { this.immatriculation = immatriculation; }
    public int getKilometrage() { return kilometrage; }
    public void setKilometrage(int kilometrage) { this.kilometrage = kilometrage; }

    public Proprietaire getProprietaire() { return proprietaire; }

    public void setProprietaire(Proprietaire nouveau) {
        if (this.proprietaire == nouveau) return;

        Proprietaire ancien = this.proprietaire;
        this.proprietaire = nouveau;

        // 1) Retirer du côté ancien propriétaire
        if (ancien != null) {
            ancien._retirerVehicule(this);
        }

        // 2) Ajouter du côté nouveau propriétaire
        if (nouveau != null) {
            nouveau._ajouterVehicule(this);
        }
    }

    public void ajouterKilometres(int km) {
        if (km < 0) throw new IllegalArgumentException("km doit être >= 0");
        kilometrage += km;
    }
}