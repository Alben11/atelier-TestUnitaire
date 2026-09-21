## Atelier — Tests unitaires (révision) + premier pipeline CI

Petit projet Java autonome (Maven, JDK 21, JUnit 6) — aucune dépendance à Spring ni à une
base de données. Il sert uniquement à revoir les bases des tests unitaires avant de construire
un pipeline d'intégration continue.

### Structure

```
atelier-tests-unitaires/
├── pom.xml
└── src/
    ├── main/java/ca/cegepmv/atelier/
    │   ├── Calculatrice.java                  ← code simple à tester (déjà complet)
    │   ├── Journal.java                        ← dépendance externe à simuler (mock)
    │   └── CalculatriceAvecHistorique.java     ← dépend de Journal (déjà complet)
    └── test/java/ca/cegepmv/atelier/
        ├── CalculatriceTest.java               ← tests à compléter (TODO)
        └── CalculatriceAvecHistoriqueTest.java  ← tests avec MOCK à compléter (TODO)
```

### Étape 1 — Compléter les tests

Ouvrez `CalculatriceTest.java`. Certains tests sont déjà écrits (niveau 1, à titre d'exemple).
Les autres contiennent un commentaire `// TODO` et un `fail("Test à compléter")` : remplacez ce
contenu par un test complet en suivant le patron **Arrange / Act / Assert**.

Les tests sont organisés en 3 niveaux de difficulté :
- **Niveau 1** — assertions simples (`assertEquals`, etc.).
- **Niveau 2** — comportements composés (`assertAll`, `assertThrows`).
- **Niveau 3** — tests paramétrés (`@ValueSource`, `@CsvSource`) et cas limites.

### Étape 2 — Exécuter les tests localement

```bash
./mvnw test
```

ou, si vous n'avez pas le wrapper Maven :

```bash
mvn test
```

Les résultats apparaissent dans la console, et un rapport détaillé est généré dans
`target/surefire-reports/` (fichiers `.txt` lisibles directement, et `.xml` pour les outils).

### Étape 2bis — Tests avec Mock (`CalculatriceAvecHistoriqueTest.java`)

`CalculatriceAvecHistorique` dépend d'un `Journal` (une interface représentant une dépendance
externe — par exemple un service qui écrirait dans un fichier ou une base de données). On ne
veut PAS exécuter un vrai journal pendant un test unitaire : on le remplace par un **mock**
(une doublure) grâce à Mockito.

Complétez les tests marqués `// TODO` dans `CalculatriceAvecHistoriqueTest.java` :
- Utilisez `verify(journalMock).enregistrer(...)` pour vérifier qu'une méthode du mock a bien
  été appelée, avec quels arguments.
- Utilisez `verify(journalMock, never()).enregistrer(anyString())` pour vérifier qu'une méthode
  n'a **pas** été appelée.

C'est la même logique que les tests précédents (Arrange/Act/Assert), sauf qu'ici l'"Assert"
porte sur une **interaction** avec la dépendance plutôt que sur une valeur de retour.

### Étape 3 — Mettre en place le pipeline (à vous de jouer)

Ajoutez vous-même un workflow GitHub Actions (`.github/workflows/ci.yml`) qui :
1. Récupère le code (`actions/checkout`).
2. Installe le JDK 21 (`actions/setup-java`).
3. Exécute `./mvnw -B clean verify` (ou `test`, selon ce que vous voulez valider).
4. Se déclenche sur chaque `push` et chaque `pull_request`.

Une fois le pipeline en place, poussez une branche avec un test qui échoue exprès pour
vérifier que le pipeline détecte bien l'échec, puis corrigez-le et vérifiez qu'il passe au vert.

> 💡 Une solution complète (tests + pipeline) existe dans un document séparé destiné à
> l'enseignant — elle ne doit pas être distribuée aux étudiants avant la fin de l'atelier.
