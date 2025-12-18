package com.fusion.facade;

import com.dauphine.SuperHeros;
import com.fusion.adapter.HeroProprietaireAdapter;
import com.vehiculemagique.Vehicule;

/**
 * Façade qui orchestre la collaboration entre les projets "superheros" et
 * "vehicule-magique". Elle masque la complexité des deux modèles et expose une
 * API dédiée aux besoins métiers de la fusion.
 */
public class FusionVehiculeSuperHeroFacade {

    /**
     * Prépare une session de fusion pour un héros et un véhicule.
     */
    public FusionSession fusionner(SuperHeros hero, Vehicule vehicule) {
        HeroProprietaireAdapter adapter = new HeroProprietaireAdapter(hero);
        adapter.assignerVehicule(vehicule);
        return new FusionSession(adapter, vehicule);
    }

    /**
     * Contexte opérationnel retourné par la façade. Il regroupe les opérations
     * utiles côté client tout en conservant l'adapter sous-jacent.
     */
    public static final class FusionSession {
        private final HeroProprietaireAdapter adapter;
        private final Vehicule vehicule;

        private FusionSession(HeroProprietaireAdapter adapter, Vehicule vehicule) {
            this.adapter = adapter;
            this.vehicule = vehicule;
        }

        public SuperHeros getHero() {
            return adapter.getHero();
        }

        public Vehicule getVehicule() {
            return vehicule;
        }

        /** Ajoute des kilomètres en réutilisant la logique véhicule. */
        public void enregistrerMission(int kilometresParcourus) {
            vehicule.ajouterKilometres(kilometresParcourus);
        }

        /** Calcule le coût d'assurance via l'adapter. */
        public int coutAssurance() {
            return adapter.calculerAssurance(vehicule);
        }

        /** Produit un message compréhensible par les deux univers. */
        public String presentation() {
            return adapter.descriptionFusion(vehicule);
        }
    }
}
