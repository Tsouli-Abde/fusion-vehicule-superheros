Feature: US-001 Définition de l'identité du Héros

  En tant que fan de comics
  Je veux créer un super-héros avec son nom de code et son super-pouvoir
  Afin de l'ajouter à ma collection

  Scenario Outline: Création réussie d'un héros basique
    Given un nom "<nom>" et un pouvoir "<pouvoir>"
    When je crée le super héros
    Then le héros doit s'appeler "<nom>"
    And son pouvoir doit être "<pouvoir>"

    Examples:
      | nom       | pouvoir           |
      | SpiderMan | Tisse des toiles  |
      | IronMan   | Armure High-Tech  |
      | Batman    | Richesse          |

  Scenario Outline: Modification des caractéristiques (Correction)
    Given un super héros initial nommé "<ancien_nom>"
    When je corrige son nom par "<nouveau_nom>"
    And je corrige son pouvoir par "<nouveau_pouvoir>"
    Then le héros doit s'appeler "<nouveau_nom>"
    And son pouvoir doit être "<nouveau_pouvoir>"

    Examples:
      | ancien_nom | nouveau_nom | nouveau_pouvoir |
      | Spidey     | SpiderMan   | Tisse des toiles|
      | Bruce      | Batman      | Arts Martiaux   |

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