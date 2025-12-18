Feature: Fusion des univers Super Hero et Vehicule Magique
  Afin de valider la façade
  En tant qu'équipe d'intégration
  Je veux décrire des user stories BDD qui vérifient l'adapter et la façade

  Background:
    Given un super héros "Batman" avec le pouvoir "protège Gotham" dans l'univers "DC"
    And un véhicule magique immatriculé "BAT-001"

  Scenario: Déployer un héros sur une mission motorisée
    When j'associe le héros au véhicule via la façade
    And j'enregistre une mission de 200 km
    Then le kilométrage du véhicule vaut 200
    And le coût d'assurance estimé est 300
    And le message fusionné contient "Batman" et "BAT-001"

  Scenario Outline: Réutiliser la façade pour plusieurs héros et missions
    Given un super héros "<nom>" avec le pouvoir "<pouvoir>" dans l'univers "<univers>"
    And un véhicule magique immatriculé "<immat>"
    When j'associe le héros au véhicule via la façade
    And j'enregistre une mission de <km> km
    Then le kilométrage du véhicule vaut <km>
    And le coût d'assurance estimé est <assurance>

    Examples:
      | nom       | pouvoir              | univers | immat    | km | assurance |
      | SpiderMan | tisse des toiles     | Marvel  | WEB-777  | 50 | 300       |
      | IronMan   | armure high-tech     | Marvel  | IRN-999  | 999 | 300      |
      | Flash     | super vitesse        | DC      | FLS-123  | 1200 | 301    |
