package com.dauphine;
/**
 * Classe univers qui permet de définir dans quel univers le super héros se trouve
 *
 * @author DUBOSCQ et LONGHI
 * @version 1.0
 */
public class Univers
{
    private String nom;

    /**
     * Constructor for objects of class Univer
     */
    public Univers(String unNom)
    {
        this.nom = unNom;
    }

    /**
     * Méthode set qui modifie le nom de l'univers
     *
     * @param  unNom  le nom de l'univers
     */
    public void setNom(String unNom)
    {
        this.nom = unNom;
    }
    
    
    /**
     * Méthode get afin de récupérer l'univers du super héro
     *
     * @return    l'univers du super héro
     */
    public String getNom()
    {
        return this.nom;
    }
}