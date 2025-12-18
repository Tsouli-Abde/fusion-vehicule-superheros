Feature: US-003 Fiche d'identité complète

  En tant qu'utilisateur de l'application
  Je veux obtenir une phrase résumant l'identité du héros
  Afin de présenter le personnage facilement

  Scenario Outline: Affichage complet de la description
    Given un héros nommé "<nom>" avec le pouvoir "<pouvoir>"
    And le héros appartient à l'univers "<univers>"
    When je demande son identité
    Then la phrase renvoyée doit être exactement "<resultat_attendu>"

    Examples:
      | nom       | pouvoir           | univers | resultat_attendu                                               |
      | SpiderMan | Tisse des toiles  | Marvel  | Je suis SpiderMan dans l'univers Marvel et je Tisse des toiles |
      | Batman    | la Richesse       | DC      | Je suis Batman dans l'univers DC et je la Richesse             |
