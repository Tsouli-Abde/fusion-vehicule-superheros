#Author: omar & tsouli
@tag
Feature: US_003 Calcul de l assurance annuelle
  En tant que proprietaire
  Je veux calculer l assurance d un vehicule
  Afin d estimer son cout annuel

  Scenario Outline: calcul du cout d assurance
    Given un vehicule immatricule "<immat>" avec un kilometrage initial <km>
    And un proprietaire nomme "<nom>"
    When je calcule l assurance du vehicule
    Then le cout de l assurance vaut <cout>

    Examples:
      | immat     | nom   | km   | cout |
      | AA-123-BB | Tsouli | 0    | 300  |
      | AA-123-BB | Omar | 2500 | 302  |
      | ZZ-999-ZZ | Omar  | 999  | 300  |
