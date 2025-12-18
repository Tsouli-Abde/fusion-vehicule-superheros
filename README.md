![Véhicule Magique](captures/voitureMagique.png)

# 🚗 L'Odyssée du Véhicule Magique

Bienvenue dans ce guide interactif. Nous allons construire pas à pas notre **Véhicule Magique** à l'aide de BlueJ. Suivez le guide !

## 1. La Genèse : Création de la Classe `Vehicule` 🚘
Nous avons conçu la classe `Vehicule`, la pierre angulaire de notre application. Elle modélise un véhicule simple grâce à son **immatriculation** 🪪 et son **kilométrage** 📏, offrant ainsi une représentation simple et claire.

### Code initial et Compilation 🛠️
La classe `Vehicule` contient deux attributs principaux et la méthode `rouler(int km)` 🚦 pour simuler l'utilisation réelle sur la route 🛣️.

La compilation dans BlueJ permet de vérifier que le code est syntaxiquement correct ✅. Une classe affichée sans hachures signifie que la compilation a été réalisée avec succès.

![Code Vehicule](captures/Screenshot%202025-12-18%20at%2014.06.37.png)
![Compilation Réussie](captures/Screenshot%202025-12-18%20at%2014.06.55.png)

---

## 2. Premiers Pas : Interaction avec l'Objet 🧩
Nous avons instancié un objet `Vehicule` de manière interactive grâce à BlueJ 🖱️. Cette approche permet de manipuler directement l’objet 🛠️ et de tester son comportement sans écrire de code supplémentaire.

### Instanciation et Inspection 🧐
L’inspection d’un objet permet d’observer son état interne 🔍. On constate ainsi que le kilométrage 📏 est initialement fixé à 0 lors de la création de l’objet 🆕✅.

![Instanciation](captures/Screenshot%202025-12-18%20at%2014.07.16.png)
![Inspection Initiale](captures/Screenshot%202025-12-18%20at%2014.07.41.png)

### En route ! (Appel de méthode) 🚦
L’appel de la méthode `rouler` entraîne une modification de l’état de l’objet 🔄. Le kilométrage 📏 augmente en fonction de la distance parcourue.

![Appel Rouler](captures/Screenshot%202025-12-18%20at%2014.07.52.png)
![Inspection Après Rouler](captures/Screenshot%202025-12-18%20at%2014.08.36.png)

---

## 3. Le Sceau de la Qualité : Tests Unitaires 🧪
Ces captures d’écran illustrent l’exécution réussie de tests unitaires pour la classe `Vehicule` à l’aide de JUnit ✅.
Le véhicule est initialisé avec l’immatriculation « AA-123-BB » dans la méthode `setUp`.

Les quatre tests validés (✓) vérifient :
1.  **Initialisation** : compteur à 0 km 📏.
2.  **Méthode `rouler()`** : kilométrage correctement incrémenté 🛣️.
3.  **Erreurs** : refus des distances négatives (`IllegalArgumentException`) 🚫.
4.  **Immatriculation** : modification possible après construction 🔧.

Avec 4 exécutions et 0 échec 🎉, la classe est validée.

![Tests JUnit](captures/Screenshot%202025-12-18%20at%2014.08.47.png)
![Tests JUnit Détail](captures/Screenshot%202025-12-18%20at%2014.09.26.png)

---

## 4. L'Alliance : Ajout du Propriétaire 🧑‍💼
Nous avons ajouté une seconde classe nommée `Proprietaire` afin de modéliser le propriétaire d’un véhicule 🚘 et enrichir la modélisation 🧩.

### Association Unidirectionnelle 🔗
La classe `Vehicule` possède une référence optionnelle vers un objet `Proprietaire` 👤.
Cette association est **unidirectionnelle** ➡️ (le véhicule connaît son propriétaire) et de multiplicité **0..1 vers 0..1**.

![Code Proprietaire](captures/Screenshot%202025-12-18%20at%2014.09.36.png)
![Diagramme de Classe](captures/Screenshot%202025-12-18%20at%2014.09.44.png)

### Instanciation et Liaison 🚗👤
Nous avons créé un objet `Proprietaire` puis l’avons associé à un objet `Vehicule` 🔗. Cela illustre la création de liens entre objets à l’exécution ⏱️.

![Liaison Objets](captures/Screenshot%202025-12-18%20at%2014.09.53.png)
![Inspection Association](captures/Screenshot%202025-12-18%20at%2014.10.41.png)

---

## 5. Collaboration et Assurance 🛡️
La méthode `calculerAssuranceAnnuelle` de la classe `Proprietaire` utilise l’état du `Vehicule` (kilométrage). C'est une parfaite illustration de la collaboration entre objets.

### Test avec Fixture (Cycle Red/Green)
Ces captures illustrent la création interactive de la méthode `testAssuranceAvecFixture`.
1.  **Barre Rouge** 🔴 : Première exécution avec une assertion volontairement erronée pour confirmer l'échec.
2.  **Barre Verte** 🟢 : Correction et validation de la logique métier (parcours de 2500 km et calcul du coût).

![Test Rouge](captures/Screenshot%202025-12-18%20at%2014.10.51.png)
![Test Vert](captures/Screenshot%202025-12-18%20at%2014.11.19.png)

---
## ✨ Seconde Itération — Les Épreuves Avancées du Véhicule Magique

Après avoir maîtrisé les premiers sortilèges, notre Véhicule Magique a dû affronter des épreuves plus subtiles, réservées aux mages confirmés. Cette seconde itération raconte comment l’univers a gagné en profondeur, en robustesse et en sagesse.

### Le Lien Sacré
**Association bidirectionnelle 0..1 ↔ \***

Jusqu’ici, le pacte entre le véhicule et son propriétaire était simple. Mais le monde réel est plus complexe :
- un **propriétaire peut posséder plusieurs véhicules**,
- un **véhicule ne peut avoir qu’un seul propriétaire (ou aucun)**.

Un lien bidirectionnel **0..1 ↔ \*** a donc été instauré entre `Vehicule` et `Proprietaire`.
Ce lien a été **soigneusement encapsulé** afin de garantir la cohérence des deux côtés. Deux gardiens (méthodes) veillent au grain :
- `Vehicule.setProprietaire(Proprietaire)` : Le point d'entrée principal.
- `Proprietaire.ajouterVehicule(Vehicule)` : Une autre voie pour sceller le pacte.

Des **tests unitaires dédiés** (`ProprietaireVehiculeAssociationTest`) vérifient que si j'achète une voiture, elle sait que je suis son propriétaire, et je sais qu'elle est à moi.

### L’Art du Raffinement
**Techniques de refactoring**

Un bon sorcier sait que la puissance ne suffit pas : le code doit rester **clair et élégant**.

Deux techniques de refactoring ont été appliquées :

#### 🔹 Rename
La méthode qui fait avancer le véhicule a été renommée pour être plus précise.
*   *Avant* : `rouler()` (C'était vague...)
*   *Maintenant* : `ajouterKilometres()` (C'est clair !)

#### 🔹 Extract Method
La logique de calcul du surcoût d'assurance était cachée au milieu d'une formule. Elle a été extraite dans une méthode privée `calculerSurcoutKilometrique` dans la classe `Proprietaire`.
*Gain* : La formule principale est plus lisible, et le détail du calcul est isolé.

### La Malédiction du « Test Infected »

En parcourant le site officiel de **JUnit** et en lisant l’article mythique *« Test Infected »* de Beck et Gamma, une vérité s’est imposée :

> Un développeur doit devenir dépendant de ses tests.

Pour adapter cette philosophie, nous avons invoqué des **Tests Paramétrés** (`VehiculeParameterizedTest`).
Au lieu d'écrire 50 fois le même test pour 50 distances différentes, nous donnons une liste de cas au test :
*   `0 + 100 + 50 = 150`
*   `10 + 0 + 5 = 15`
...et le test s'exécute pour chacun d'eux. Magique !

### Le Rituel de l’Invocation
**Exécution des tests en ligne de commande**

Un sort n’est véritablement fiable que s’il fonctionne hors de l’IDE. Les tests ont été exécutés via la commande suprême :

```bash
mvn test
```

### 🍀 Épreuve 18 — La Loi de Murphy

> "Tout ce qui est susceptible de mal tourner tournera mal."

Dans notre péripétie, cela s'est vérifié : nous pensions avoir tout prévu, mais qu'arrive-t-il si on essaie d'ajouter un véhicule `null` à un propriétaire ? Ou de retirer un véhicule qui ne nous appartient pas ?
Heureusement, nos gardes-fous (les exceptions et les checks dans le code) étaient là pour empêcher le chaos.
