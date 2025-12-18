#Author: omar & tsouli
@tag
Feature: US_001 Suivi du kilometrage
  En tant que utilisateur
  Je veux faire rouler un vehicule
  Afin de suivre son kilometrage

  Scenario Outline: cumul du kilometrage
    Given un vehicule immatricule "<immat>" avec un kilometrage initial <k0>
    When je roule de <km1> km
    And je roule de <km2> km
    Then le kilometrage vaut <kfinal>

    Examples:
      | immat     | k0 | km1 | km2 | kfinal |
      | AA-123-BB | 0  | 100 | 50  | 150    |
      | ZZ-999-ZZ | 10 | 0   | 5   | 15     |

  Scenario Outline: refus de distance negative
    Given un vehicule immatricule "<immat>" avec un kilometrage initial <k0>
    When je tente de rouler de <kmNeg> km
    Then une exception IllegalArgumentException est levee

    Examples:
      | immat     | k0 | kmNeg |
      | AA-123-BB | 0  | -10   |
      | ZZ-999-ZZ | 7  | -1    |