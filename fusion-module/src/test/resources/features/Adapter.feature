Feature: Test du Pattern Adapter
  En tant qu'équipe d'intégration, je veux vérifier que l'Adapter convertit bien 
  un SuperHeros en Propriétaire

  Background:
    Given un super héros nommé "Spider-Man" avec le pouvoir "lance des toiles"

  Scenario: Synchronisation de l'identité
    When je crée un adaptateur pour ce héros
    Then l'adaptateur doit exposer un propriétaire nommé "Spider-Man"

  Scenario: Délégation de l'attribution de véhicule
    Given un véhicule immatriculé "WEB-2025"
    And je crée un adaptateur pour ce héros
    When j'assigne le véhicule au héros via l'adaptateur
    Then le véhicule doit avoir pour propriétaire "Spider-Man"
    And la liste des véhicules de l'adaptateur doit contenir "WEB-2025"

  Scenario Outline: Délégation du calcul d'assurance via l'adaptateur
    Given un véhicule immatriculé "V-100" avec <km> km au compteur
    And je crée un adaptateur pour ce héros
    When j'assigne le véhicule au héros via l'adaptateur
    Then le coût d'assurance calculé par l'adaptateur doit être <montant>

    Examples:
      | km    | montant |
      | 0     | 300     |
      | 500   | 300     |
      | 1500  | 301     |
      | 10000 | 310     |