#Author: omar & tsouli
@tag
Feature: US_002 Associer un proprietaire a un vehicule
  En tant que utilisateur
  Je veux associer un proprietaire a un vehicule
  Afin de connaitre a qui il appartient

  Scenario Outline: association d un proprietaire
    Given un vehicule immatricule "<immat>" sans proprietaire
    And un proprietaire nomme "<nom>"
    When j associe le proprietaire au vehicule
    Then le proprietaire du vehicule est "<nom>"

    Examples:
      | immat     | nom    |
      | AA-123-BB | Tsouli  |
      | ZZ-999-ZZ | Omar   |

  Scenario: vehicule sans proprietaire
    Given un vehicule immatricule "AA-123-BB" sans proprietaire
    Then le vehicule n a pas de proprietaire
