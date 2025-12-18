Feature: US-002 Gestion de l'Univers

  En tant que gardien du multivers
  Je veux créer un Univers et y affecter un Super-Héros
  Afin de savoir s'il appartient à Marvel ou DC Comics

  Scenario Outline: Association d'un héros à un univers
    Given un super héros nommé "<nom_heros>" existe
    And un univers nommé "<nom_univers>" existe
    When j'affecte le héros à l'univers "<nom_univers>"
    Then l'univers du héros doit être "<nom_univers>"

    Examples:
      | nom_heros | nom_univers |
      | SpiderMan | Marvel      |
      | Batman    | DC Comics   |
      | Invincible| Image       |

  Scenario Outline: Changement d'univers (Transfert)
    Given un héros "<nom_heros>" déjà dans l'univers "<univers_depart>"
    When je transfère le héros vers l'univers "<univers_arrivee>"
    Then l'univers du héros doit être "<univers_arrivee>"

    Examples:
      | nom_heros | univers_depart | univers_arrivee |
      | SpiderMan | Sony Pictures  | Marvel MCU      |
