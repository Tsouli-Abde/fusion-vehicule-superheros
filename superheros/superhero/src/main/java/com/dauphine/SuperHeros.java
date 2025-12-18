package com.dauphine;

/**
 * Un super héro possède un nom et un pouvoir
 *
 * @author DUBOSCQ et LONGHI
 * @version 1.0
 */
public class SuperHeros
{
    private String nom;
    private String pouvoir;
    private Univers univers;
    private Groupe groupe;

    /**
     * Constructor for objects of class SuperHero
     */
    public SuperHeros(String unNom, String unPouvoir)
    {
        nom = unNom;
        pouvoir = unPouvoir;
        
    }
    
    /**
     * Méthode get afin de récupérer le nom du super héro
     *
     * @return    le nom du super héro
     */
    public String getNom()
    {
        return this.nom;
    }
    
    /**
     * Méthode get afin de récupérer le pouvoir du super héro
     *
     * @return    le pouvoir du super héro
     */
    public String getPouvoir()
    {
        return this.pouvoir;
    }
    
    /**
     * Méthode get afin de récupérer l'univers du super héro
     *
     * @return    l'univers du super héro
     */
    public Univers getUnivers()
    {
        return this.univers;
    }

    /**
     * Méthode get afin de récupérer le groupe du super héro
     *
     * @return    le groupe du super héro
     */
    public Groupe getGroupe()
    {
        return this.groupe;
    }
    
    /**
     * Méthode set qui modifie le nom du super héro
     *
     * @param  unNom  le nom du super héro
     */
    public void setNom(String unNom)
    {
        this.nom = unNom;
    }
    
    /**
     * Méthode set qui modifie le pouvoir du super héro
     *
     * @param  unPouvoir  le pouvoir du super héro
     */
    public void setPouvoir(String unPouvoir)
    {
        this.pouvoir = unPouvoir;
    }

    /**
     * Modifie le groupe du super héros
     * Si le héros change de groupe, il est retiré de l'ancien et ajouté au nouveau automatiquement
     */
    public void setGroupe(Groupe nouveauGroupe) {
        if (this.groupe == nouveauGroupe) {
            return;
        }
        Groupe vieuxGroupe = this.groupe;
        this.groupe = nouveauGroupe;
        if (vieuxGroupe != null) {
            vieuxGroupe.supprimerMembre(this);
        }
        if (nouveauGroupe != null) {
            nouveauGroupe.ajouterMembre(this);
        }
    }
    
    /**
     * Méthode set qui modifie l'univers du super héro
     *
     * @param  unUnivers  l'univers du super héro
     */
    public void setUnivers(Univers unUnivers)
    {
        this.univers = unUnivers;
    }
    
    /**
     * Méthode set qui modifie l'univers du super héro
     *
     * @param  unUnivers  l'univers du super héro
     */
    public String toString() {
        String nomUnivers = (this.univers != null) ? this.univers.getNom() : "Inconnu";
        return "Je suis " + this.nom + " dans l'univers " + nomUnivers + " et je " + this.pouvoir;
    }
}