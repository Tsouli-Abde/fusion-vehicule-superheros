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
